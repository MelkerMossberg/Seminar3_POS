package se.kth.iv350.POS.database;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

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

