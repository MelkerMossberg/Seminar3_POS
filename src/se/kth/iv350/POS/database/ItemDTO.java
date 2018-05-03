package se.kth.iv350.POS.database;

/**
 * Represents an item
 */
public class ItemDTO {
    final String itemID;
    final int itemPrice;
    final String itemName;

    /**
     * Crates an instance of an item
     * @param id Identifies the specific type of item.
     * @param price The price of the item.
     * @param name The name of that item
     */
    public ItemDTO (String id, int price, String name){
        this.itemID = id;
        this.itemPrice = price;
        this.itemName = name;
    }
    
    public String getID (){
        return this.itemID;
    }

    public int getItemPrice (){
        return this.itemPrice;
    }

    public String getItemName (){
        return this.itemName;
    }

}
