package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.exceptions.SearchFailedException;

import java.util.ArrayList;

/**
 * Interface for different search strategies / algorithms.
 */
public interface SearchStrategy {
    ItemDTO searchOperation(String itemCall, ArrayList<ItemDTO> databse) throws SearchFailedException;
}
