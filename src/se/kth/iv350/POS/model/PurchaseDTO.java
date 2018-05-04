package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;

import java.util.ArrayList;

public class PurchaseDTO {

    final String purchaseID;
    final ArrayList<ItemDTO> items;
    final int totalPrice;
    final ArrayList<UniqueItem> uniqueItems;
    final int discount;

    /**
     * Creates a new instance of <code>PurchaseDTO</code>.
     * @param purchaseID The ID of the <code>PurchaseDTO</code>.
     * @param items The list of items in the <code>PurchaseDTO</code>.
     * @param totalPrice The total price of the items.
     * @param uniqueItems A list of unique items in the purchase, which also contains an amount of
     *                    each unique item.
     * @param disocunt The buying customer's discount.
     */

    public PurchaseDTO(String purchaseID, ArrayList<ItemDTO> items, int totalPrice, ArrayList<UniqueItem> uniqueItems, int disocunt){
        this.purchaseID = purchaseID;
        this.items = items;
        this.totalPrice = totalPrice;
        this.uniqueItems = uniqueItems;
        this.discount = disocunt;
    }

    public String getPurchaseID() {
        return purchaseID;
    }

    public ArrayList<ItemDTO> getItems() {
        return items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<UniqueItem> getUniqueItems (){
        return uniqueItems;
    }

    public int getDiscount(){
        return this.discount;
    }
}
