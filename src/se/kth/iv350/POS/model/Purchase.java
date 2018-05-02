package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;

import java.util.ArrayList;

public class Purchase {

    final String purchaseID;
    private ArrayList<ItemDTO> items;
    private int totalPrice;
    private ArrayList<UniqueItem> uniqueItems = new ArrayList<>();

    public Purchase (String id){
        this.purchaseID = id;
        this.items = new ArrayList<ItemDTO>();
        this.totalPrice = 0;
    }

    public PurchaseDTO getPurchaseData(){
        PurchaseDTO purchase = new PurchaseDTO(this.purchaseID, this.items, this.totalPrice, this.uniqueItems);
        return purchase;
    }

    public void addItem(ItemDTO validItem) {
        this.items.add(validItem);

        for(UniqueItem item : uniqueItems)
            if (item.getItemDTO().getID().equals(validItem.getID())){
                item.incrementAmount();
                return;
            }
        uniqueItems.add(new UniqueItem(validItem));
    }

    public void updateTotal() {
        int newTotal = 0;
        for (ItemDTO item : this.items)
            newTotal += item.getItemPrice();
        this.totalPrice = newTotal;
    }

    public ArrayList<UniqueItem> getUniqueItems (){
        return this.uniqueItems;
    }
}


