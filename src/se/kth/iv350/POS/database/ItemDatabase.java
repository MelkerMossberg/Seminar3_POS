package se.kth.iv350.POS.database;

import se.kth.iv350.POS.model.PurchaseDTO;

import java.util.*;

public class ItemDatabase {

    ArrayList<ItemDTO> itemDB = new ArrayList();

    public ItemDatabase (){

        this.itemDB.add(new ItemDTO("0", 10, "Apple"));
        this.itemDB.add(new ItemDTO("1", 25, "Cake"));
        this.itemDB.add(new ItemDTO("2", 5, "Shampoo"));
        this.itemDB.add(new ItemDTO("3", 8, "Coffe"));
        this.itemDB.add(new ItemDTO("4", 7, "Salami"));

    }

    public ItemDTO searchByID(String searchedID){

        for(int i = 0; i < itemDB.size(); i++){

            if (itemDB.get(i).getID().equals(searchedID)){
                return itemDB.get(i);
            }
        }
        return null;
    }

    public void UpdateItemDatabase(PurchaseDTO purchaseDTO){

    }

}
