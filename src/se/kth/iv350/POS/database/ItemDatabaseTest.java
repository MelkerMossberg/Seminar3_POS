package se.kth.iv350.POS.database;

import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

class ItemDatabaseTest {


    ItemDatabase itemDatabase = new ItemDatabase();

    @Test
    void searchByID() {
        ItemDTO expectedResult = itemDatabase.itemDB.get(0);
        String searchedID = "1";
        ItemDTO result = itemDatabase.searchByID(searchedID);
        assertEquals(expectedResult, result);
        }
    }

