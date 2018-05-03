package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;

import java.util.ArrayList;

public class PurchaseDTO {

    final String purchaseID;
    final ArrayList<ItemDTO> items;
    final int totalPrice;
    final ArrayList<UniqueItem> uniqueItems;
    final int discount;

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
