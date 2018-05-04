package se.kth.iv350.POS.controller;

import se.kth.iv350.POS.database.CustomerDTO;
import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.integration.AccountingSystem;
import se.kth.iv350.POS.integration.CustomerDBHandler;
import se.kth.iv350.POS.integration.ItemDBHandler;
import se.kth.iv350.POS.model.DiscountControl;
import se.kth.iv350.POS.model.Purchase;
import se.kth.iv350.POS.model.PurchaseDTO;
import se.kth.iv350.POS.model.UniqueItem;

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
    ItemDBHandler itemDBHandler;
    CustomerDBHandler customerDBHandler;
    ArrayList<Purchase> salesList = new ArrayList();
    Purchase purchase;
    AccountingSystem accountingSystem;

    public Controller (ItemDBHandler itemDBHandler, CustomerDBHandler customerDBHandler, AccountingSystem accountingSystem){
        this.itemDBHandler = itemDBHandler;
        this.customerDBHandler = customerDBHandler;
        this.purchase = null;
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
        return this.purchase.getPurchaseData();
    }

    /**
     * When cashier scans a new item. The ID is verified with the database before being added to the purchase.
     * @param itemID String generated from barcode scan
     * @return updated information about purchase
     */
    public PurchaseDTO registerItem(String itemID){
        ItemDTO validItem = itemDBHandler.getIfValidItem(itemID);
        if (validItem == null){
            System.out.println("Error Item not valid");
            return this.purchase.getPurchaseData(); // return previous PurchaseDTO
        }else{
            this.purchase.addItem(validItem);
            return purchase.getPurchaseData();
        }
    }

    /**
     * Sends purchase information to register which prints a receipt
     * @param amount is the amount payed by the customer
     * @return returns the amount of change to give back to the customer
     */
    public int payment(int amount){
        return purchase.finalizeSale(amount, accountingSystem);
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
        System.out.println("END " + newPrice);
        return purchase.setNewPrice(newPrice);
    }

}
