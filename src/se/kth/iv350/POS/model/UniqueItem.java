package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;

public class UniqueItem {
    private ItemDTO item;
    private int amount;

    public UniqueItem(ItemDTO item){
        this.item = item;
        this.amount = 1;
    }

    public ItemDTO getItemDTO(){
        return this.item;
    }

    public void incrementAmount(){
        this.amount++;
    }

    public int getAmount(){
        return this.amount;
    }

    public Object[] getRowObject(){
        // create an array of objects to set the row data
        Object[] newRow = new Object[4];
        newRow[0] = this.item.getID();
        newRow[1] = this.item.getItemName();
        newRow[2] = this.item.getItemPrice();
        newRow[3] = this.amount;
        return newRow;

    }

}
