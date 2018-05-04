package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;

public class UniqueItem {
    private ItemDTO item;
    private int amount;

    /**
     * Creates an instance of <code>UniqueItem</code>. Holds an <code>ItemDTO</code> and an amount.
     * @param item the <code>ItemDTO</code> from which to create the <code>UniqueItem</code>
     */

    public UniqueItem(ItemDTO item){
        this.item = item;
        this.amount = 1;
    }

    public ItemDTO getItemDTO(){
        return this.item;
    }

    /**
     * Increment the amount of the <code>UniqueItem</code>.
     */

    public void incrementAmount(){
        this.amount++;
    }

    public int getAmount(){
        return this.amount;
    }

    /**
     * Creates a list of objects to be used buy the view.
     * @return
     */

    public Object[] getRowObject(){
        Object[] newRow = new Object[4];
        newRow[0] = this.item.getID();
        newRow[1] = this.item.getItemName();
        newRow[2] = this.item.getItemPrice();
        newRow[3] = this.amount;
        return newRow;

    }

}
