package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.exceptions.DatabaseFailureException;
import se.kth.iv350.POS.exceptions.SearchFailedException;

import java.util.ArrayList;

public class SearchByID implements SearchStrategy{

    /**
     * Searches the database by a String "ID".
     * @param itemCall the "ID" user is looking for
     * @param database is where the algorithm will look
     * @return An ItemDTO to be added to the <code>Purchase</code>
     * @throws SearchFailedException If the item ID is invalid.
     */
    @Override
    public ItemDTO searchOperation(String itemCall, ArrayList<ItemDTO> database) throws SearchFailedException {

        for (ItemDTO item : database){
            if (itemCall.equals("5"))
                throw new DatabaseFailureException("Fail: Searched item: 5");
            if (itemCall.equals(item.getID()))
                return item;

        }
        throw new SearchFailedException("ID of: '" + itemCall +"' was not found.");
    }
}


