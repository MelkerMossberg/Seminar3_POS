package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.exceptions.ItemNotFoundException;

import java.util.ArrayList;

/**
 * Represents a search context that has a certain search strategy. Depending on the strategy,
 * a certain search algorithm will be used in the search context.
 */
public class SearchContext {
    private SearchStrategy strategy;

    public SearchContext(SearchStrategy strategy){
        this.strategy = strategy;
    }

    public ItemDTO searchItem(String itemCall, ArrayList<ItemDTO> database) throws ItemNotFoundException {
        return strategy.searchOperation(itemCall, database);
    }

}
