package se.kth.iv350.POS.controller;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.integration.ItemDBHandler;
import se.kth.iv350.POS.model.Purchase;
import se.kth.iv350.POS.model.PurchaseDTO;
import se.kth.iv350.POS.model.UniqueItem;

import java.util.ArrayList;

public class Controller {

    /**
     * Setup-variables for the controller.
     * <code>itemDBHandler</code> integrates to the item database
     * <code>salesList</code> keeps private record of Purchases made since the start of the program
     * <code>purchase</code> is the current purchase
     */
    ItemDBHandler itemDBHandler;
    ArrayList<Purchase> salesList = new ArrayList();
    Purchase purchase;

    public Controller (ItemDBHandler itemDBHandler){
        this.itemDBHandler = itemDBHandler;
        this.purchase = null;
    }

    /**
     * Creates a new purchase session. Give this session a new ID.
     * @return an empty data transfer object
     */
    public PurchaseDTO startNewSale (){
        String newPurchaseID = Integer.toString(salesList.size());
        this.purchase = new Purchase(newPurchaseID);
        salesList.add(this.purchase);
        return this.purchase.getPurchaseData();
    }

    /**
     * Cashier scans a new item. The ID is verified with the database before being added to the purchase.
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



}
