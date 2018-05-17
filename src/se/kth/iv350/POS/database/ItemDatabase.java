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

    public ItemDTO getItemDTO(int i){
        return this.itemDB.get(i);
    }

    public ArrayList<ItemDTO> getItems(){
        return this.itemDB;
    }


}
