package se.kth.iv350.POS.controller;

import se.kth.iv350.POS.database.DatabaseFailureException;
import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.database.ItemIDNotFoundException;
import se.kth.iv350.POS.integration.AccountingSystem;
import se.kth.iv350.POS.integration.CustomerDBHandler;
import se.kth.iv350.POS.integration.ItemDBHandler;
import se.kth.iv350.POS.model.DiscountControl;
import se.kth.iv350.POS.model.Purchase;
import se.kth.iv350.POS.model.PurchaseDTO;
import se.kth.iv350.POS.model.TotalPurchasedObserver;
import se.kth.iv350.POS.util.LogHandler;

import javax.swing.*;
import java.beans.ExceptionListener;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Represents agent that handles all method calls from the <code>View</code>
 */
public class Controller {

    /**
     * Setup members of the controller.
     * <code>itemDBHandler</code> integrates to the item <code>itemDatabase</code>
     * <code>customerDBHandler</code> integrates to the item <code>customerDatabase</code>
     * <code>salesList</code> keeps private record of Purchases made since the start of the program
     * <code>purchase</code> is the current purchase
     */
    private ItemDBHandler itemDBHandler;
    private CustomerDBHandler customerDBHandler;
    private ArrayList<Purchase> salesList = new ArrayList();
    private Purchase purchase;
    private AccountingSystem accountingSystem;
    private TotalPurchasedObserver totalPurchaseObserver;

    public Controller (ItemDBHandler itemDBHandler, CustomerDBHandler customerDBHandler, AccountingSystem accountingSystem){
        this.itemDBHandler = itemDBHandler;
        this.customerDBHandler = customerDBHandler;
        this.accountingSystem = accountingSystem;
    }

    /**
     * Creates a new purchase session. Give this session a new ID.
     * @return an empty <code>purchaseDTO</code>
     */
    public PurchaseDTO startNewSale (){
        String newPurchaseID = Integer.toString(salesList.size());
        this.purchase = new Purchase(newPurchaseID);
        salesList.add(this.purchase);
        purchase.addTotalPurshasedObserver(this.totalPurchaseObserver);
        return this.purchase.getPurchaseData();
    }

    /**
     * When cashier scans a new item. The ID is verified with the database before being added to the purchase.
     * @param itemID String generated from barcode scan
     * @return updated information about purchase
     */
    public PurchaseDTO registerItem(String itemID)
            throws RegisterFailedException, OperationFailedException {
        ItemDTO validItem = null;
        try {
            validItem = itemDBHandler.getIfValidItem(itemID);
        }catch (ItemIDNotFoundException exc){
            throw new RegisterFailedException("Failed to register." + exc.getMessage(), exc);
        }catch (DatabaseFailureException dbExc){
            throw new OperationFailedException("Failed to register.", dbExc);
        }

        this.purchase.addItem(validItem);
        return purchase.getPurchaseData();

    }

    /**
     * Sends purchase information to register which prints a receipt
     * @param amount is the amount payed by the customer
     * @return returns the amount of change to give back to the customer
     */
    public int payment(int amount){
        return purchase.calculateChange(amount);
    }

    public void closePurchase(){
        purchase.finalizeSale(this.accountingSystem);
    }

    /**
     * Sends data to calculate customer's ID and calculate new price.
     * @param customerID The customers personal ID. IDs "1" to "3" exists.
     * @return a PurchaseDTO with updated price.
     */
    public PurchaseDTO tryDiscount(String customerID){
        int discount = customerDBHandler.getDiscountIfValid(customerID);
        purchase.setNewDiscount(discount);
        DiscountControl dc = new DiscountControl();
        int newPrice = (int) dc.calculateDiscount(purchase.getPurchaseData());
        return purchase.setNewPrice(newPrice);
    }

    public void addTotalPurchasedObserver(TotalPurchasedObserver observer){
        this.totalPurchaseObserver = observer;
    }

}
