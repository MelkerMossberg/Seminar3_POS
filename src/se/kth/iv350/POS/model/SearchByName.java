package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.exceptions.SearchFailedException;

import java.util.ArrayList;

public class SearchByName implements SearchStrategy {

    /**
     * Searches the database by a String "Name".
     * @param itemCall the "Name" user is looking for
     * @param database is where the algorithm will look
     * @return An ItemDTO to be added to the <code>Purchase</code>
     * @throws SearchFailedException If the item Name is invalid.
     */
    @Override
    public ItemDTO searchOperation(String itemCall, ArrayList<ItemDTO> database) throws SearchFailedException {
        for (ItemDTO item : database){
            if (itemCall.equals(item.getItemName())){
                return item;
            }
        }
        throw new SearchFailedException("ID of: '" + itemCall +"' was not found in database.");
    }
}
