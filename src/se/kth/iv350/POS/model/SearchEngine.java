package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.exceptions.DatabaseFailureException;
import se.kth.iv350.POS.exceptions.SearchFailedException;
import se.kth.iv350.POS.integration.ItemDBHandler;

import java.util.ArrayList;

/**
 * Represents the agent that handles a unique search in the database.
 * It decides what search strategy that will be implemented during runtime.
 */
public class SearchEngine {

    ItemDBHandler itemDBHandler;
    public SearchEngine (ItemDBHandler itemDBHandler){
        this.itemDBHandler = itemDBHandler;
    }

    public ItemDTO searchItem(String itemCall, String searchStrategy) throws SearchFailedException, DatabaseFailureException {
        ArrayList<ItemDTO> database = itemDBHandler.fetchDatabase();
        SearchContext context = null;
        if (searchStrategy.equals("ID")){
            context = new SearchContext(new SearchByID());
        }else if (searchStrategy.equals("Name")) {
            context = new SearchContext(new SearchByName());
        }

        return context.searchItem(itemCall, database);
    }
}
