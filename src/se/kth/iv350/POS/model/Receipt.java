package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.integration.ReceiptPrinter;

import java.util.ArrayList;

public class Receipt {
    private ArrayList<UniqueItem> uniqueItems;
    private int totalPrice;
    private int change;
    private int amountPayed;

    /**
     * Creates an instance of <code>Receipt</code>
     * @param purchaseDTO The <code>PurchaseDTO</code> from which the instance sets it's members (a list of
     *                    the unique items, the total price, the amount payed, and the change.
     * @param amountPayed The amount payed by the customer.
     * @param change The change given to the customer.
     */

    public Receipt(PurchaseDTO purchaseDTO, int amountPayed, int change) {
        this.uniqueItems = purchaseDTO.uniqueItems;
        this.totalPrice = purchaseDTO.totalPrice;
        this.amountPayed = amountPayed;
        this.change = change;
    }

    public ArrayList<UniqueItem> getUniqueItems(){
        return uniqueItems;
    }

    public int getTotalPrice(){
        return totalPrice;
    }

    public int getAmountPayed(){ return amountPayed; }

    public int getChange(){ return change; }
}

