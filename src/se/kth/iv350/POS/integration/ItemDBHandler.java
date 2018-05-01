package se.kth.iv350.POS.integration;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.database.ItemDatabase;

public class ItemDBHandler {

    ItemDatabase itemDatabase;

    public ItemDBHandler(ItemDatabase database){
        this.itemDatabase = database;
    }

    public ItemDTO getIfValidItem(String itemID){
        return itemDatabase.searchByID(itemID);
    }


}
