package se.kth.iv350.POS.database;

import java.util.*;

/**
 * Represents a fictional database. It contains 5 items in a ArrayList.
 */
public class ItemDatabase {

    private ArrayList<ItemDTO> itemDB = new ArrayList();

    public ItemDatabase (){
        this.itemDB.add(new ItemDTO("0", 10, "Apple"));
        this.itemDB.add(new ItemDTO("1", 25, "Cake"));
        this.itemDB.add(new ItemDTO("2", 5, "Shampoo"));
        this.itemDB.add(new ItemDTO("3", 8, "Coffe"));
        this.itemDB.add(new ItemDTO("4", 7, "Salami"));
        this.itemDB.add(new ItemDTO("5", 1000, "Fail item"));
    }

    /**
     * Searches for an item that matches a given String.
     * @param searchedID This represents a barcode on an item. "0" to "4" exists in database.
     * @return An ItemDTO which is the data-type used everywhere else in the system.
     */
    public ItemDTO searchByID(String searchedID)
            throws ItemIDNotFoundException, DatabaseFailureException{

        if (searchedID.equals("5")){
            throw new DatabaseFailureException("Database failure. Entered: " + searchedID);
        }

        for (int i = 0; i < itemDB.size(); i++) {

            if (itemDB.get(i).getID().equals(searchedID)) {
                return itemDB.get(i);
            }
        }
        throw new ItemIDNotFoundException("ID of: '" + searchedID +"' was not found in database.");

    }

    public ItemDTO getItemDTO(int i){
        return this.itemDB.get(i);
    }


}
