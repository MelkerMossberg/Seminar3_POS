package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.database.ItemIDNotFoundException;

import java.util.ArrayList;

public class SearchContext {
    private SearchStrategy strategy;

    public SearchContext(SearchStrategy strategy){
        this.strategy = strategy;
    }

    public ItemDTO searchItem(String itemCall, ArrayList<ItemDTO> database) throws ItemIDNotFoundException {
        return strategy.searchOperation(itemCall, database);
    }

}
