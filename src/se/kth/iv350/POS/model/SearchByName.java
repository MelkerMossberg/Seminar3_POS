package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;

import java.util.ArrayList;

public class SearchByName implements SearchStrategy {
    @Override
    public ItemDTO searchOperation(String itemCall, ArrayList<ItemDTO> database) throws ItemNotFoundException {
        for (ItemDTO item : database){
            if (itemCall.equals(item.getItemName())){
                return item;
            }
        }
        throw new ItemNotFoundException("ID of: '" + itemCall +"' was not found in database.");
    }
}
