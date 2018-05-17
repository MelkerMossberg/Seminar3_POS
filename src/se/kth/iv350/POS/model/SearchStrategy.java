package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.database.ItemIDNotFoundException;

import java.util.ArrayList;

public interface SearchStrategy {
    public ItemDTO searchOperation(String itemCall, ArrayList<ItemDTO> databse) throws ItemIDNotFoundException;
}
