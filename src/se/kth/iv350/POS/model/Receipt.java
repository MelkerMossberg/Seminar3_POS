package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.integration.ReceiptPrinter;

import java.util.ArrayList;

public class Receipt {
    private ArrayList<UniqueItem> uniqueItems;
    private int totalPrice;
    private int change;
    private int amountPayed;

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
}

