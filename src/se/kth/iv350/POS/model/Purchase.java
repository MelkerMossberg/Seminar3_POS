package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.integration.AccountingSystem;
import se.kth.iv350.POS.integration.ItemDBHandler;

import java.util.ArrayList;

public class Purchase {

    final String purchaseID;
    private ArrayList<ItemDTO> items;
    private ArrayList<UniqueItem> uniqueItems = new ArrayList<>();
    private int totalPrice;
    private int amountPayed;
    private int change;
    private int discount;

    public Purchase (String id){
        this.purchaseID = id;
        this.items = new ArrayList<ItemDTO>();
        this.totalPrice = 0;
    }

    public PurchaseDTO getPurchaseData(){
        PurchaseDTO purchase = new PurchaseDTO(this.purchaseID, this.items, this.totalPrice, this.uniqueItems, this.discount);
        return purchase;
    }

    public void addItem(ItemDTO validItem) {
        this.items.add(validItem);

        for(UniqueItem item : uniqueItems)
            if (item.getItemDTO().getID().equals(validItem.getID())){
                item.incrementAmount();
                updateTotal();
                return;
            }
        uniqueItems.add(new UniqueItem(validItem));
        updateTotal();
    }

    private void updateTotal() {
        int newTotal = 0;
        for (ItemDTO item : this.items)
            newTotal += item.getItemPrice();
        this.totalPrice = newTotal;
    }

    public ArrayList<UniqueItem> getUniqueItems (){
        return this.uniqueItems;
    }

    public int finalizeSale(int amount, ItemDBHandler itemDBHandler, AccountingSystem accountingSystem){
        this.amountPayed = amount;
        this.change = CalculateChange();
        Register register = new Register();
        register.getReceipt(getPurchaseData(), amountPayed, change);
        accountingSystem.updateAccounting(getPurchaseData());
        return this.change;
    }

    private int CalculateChange(){
        return (this.amountPayed - this.totalPrice);
    }

    public ArrayList<ItemDTO> getItems(){
        return this.items;
    }

    public PurchaseDTO setNewPrice (int newPrice){
        this.totalPrice = newPrice;
        return getPurchaseData();
    }

    public void setNewDiscount(int discount) {
        this.discount = discount;
    }
    public int getDiscount() {
        return this.discount;
    }
}


