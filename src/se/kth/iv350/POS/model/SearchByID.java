package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.exceptions.DatabaseFailureException;
import se.kth.iv350.POS.exceptions.ItemNotFoundException;

import java.util.ArrayList;

public class SearchByID implements SearchStrategy{

    /**
     * Searches the database by a String "ID".
     * @param itemCall the "ID" user is looking for
     * @param database is where the algorithm will look
     * @return An ItemDTO to be added to the <code>Purchase</code>
     * @throws ItemNotFoundException If the item ID is invalid.
     */
    @Override
    public ItemDTO searchOperation(String itemCall, ArrayList<ItemDTO> database) throws ItemNotFoundException {

        for (ItemDTO item : database){
            if (itemCall.equals("5"))
                throw new DatabaseFailureException("Fail: Searched item: " + item.getID());
            if (itemCall.equals(item.getID()))
                return item;

        }
        throw new ItemNotFoundException("ID of: '" + itemCall +"' was not found.");
    }
}


