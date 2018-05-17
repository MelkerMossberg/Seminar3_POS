package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.database.ItemIDNotFoundException;

import java.util.ArrayList;

public class SearchByID implements SearchStrategy{
    @Override
    public ItemDTO searchOperation(String itemCall, ArrayList<ItemDTO> database) throws ItemIDNotFoundException {

        for (ItemDTO item : database){
            if (itemCall.equals(item.getID())){
                return item;
            }
        }
        throw new ItemIDNotFoundException("ID of: '" + itemCall +"' was not found in database.");
    }
}


