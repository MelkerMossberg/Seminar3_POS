package se.kth.iv350.POS.database;

public class ItemDTO {

    final String itemID;
    final int itemPrice;
    final String itemName;

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
