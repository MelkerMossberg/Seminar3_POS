package se.kth.iv350.POS.integration;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.database.ItemDatabase;

import java.util.ArrayList;

/**
 * Represents agent that handles requests to the ItemDatabase
 */
public class ItemDBHandler {

    ItemDatabase itemDatabase;

    public ItemDBHandler(ItemDatabase database){
        this.itemDatabase = database;
    }

    /**
     * Searches <code>ItemDatabase</code> for matching String.
     * @return ItemDTO if parameter input was valid. Otherwise returns null.
     */
    public ArrayList<ItemDTO> fetchDatabase(){
        return itemDatabase.getItems();
    }

}
