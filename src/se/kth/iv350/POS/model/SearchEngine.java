package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.integration.ItemDBHandler;

import java.util.ArrayList;

public class SearchEngine {
    ItemDBHandler itemDBHandler;
    public SearchEngine (ItemDBHandler itemDBHandler){
        this.itemDBHandler = itemDBHandler;
    }


    public ItemDTO searchItem(String itemCall, String searchStrategy) throws ItemNotFoundException {
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
