package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;

import java.util.ArrayList;

public interface SearchStrategy {
    ItemDTO searchOperation(String itemCall, ArrayList<ItemDTO> databse) throws ItemNotFoundException;
}
