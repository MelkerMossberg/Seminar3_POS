package se.kth.iv350.POS.database;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class ItemDatabaseTest {

    ItemDatabase itemDatabase = new ItemDatabase();

    @Test
    public void searchByIDgetCorrectValue() {
        ItemDTO expectedResult = itemDatabase.getItemDTO(0);
        String searchedID = "0";
        ItemDTO result = itemDatabase.searchByID(searchedID);
        assertEquals(expectedResult, result);
    }


    @Test
    public void searchByIDgetNull() {
        ItemDTO expectedResult = itemDatabase.getItemDTO(0);
        String searchedID = "7";
        ItemDTO result = itemDatabase.searchByID(searchedID);
        assertEquals(null, result);
    }

    @Test
    public void searchByIDwithNullInput() {
        ItemDTO expectedResult = null;
        String searchedID = "";
        ItemDTO result = itemDatabase.searchByID(searchedID);
        assertEquals(expectedResult, result);
    }

}