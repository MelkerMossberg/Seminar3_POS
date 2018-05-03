package se.kth.iv350.POS.integration;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.database.ItemDatabase;
import se.kth.iv350.POS.model.Purchase;
import se.kth.iv350.POS.model.PurchaseDTO;

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
     * @param itemID is String to be matched in database.
     * @return ItemDTO if parameter input was valid. Otherwise returns null.
     */
    public ItemDTO getIfValidItem(String itemID){
        return itemDatabase.searchByID(itemID);
    }

}
