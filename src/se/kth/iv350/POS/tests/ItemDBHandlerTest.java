package se.kth.iv350.POS.tests;

import org.junit.Test;
import se.kth.iv350.POS.database.ItemDatabase;
import se.kth.iv350.POS.integration.ItemDBHandler;

import static org.junit.Assert.*;

public class ItemDBHandlerTest {

    ItemDatabase itemDB = new ItemDatabase();
    ItemDBHandler itemDBHandler = new ItemDBHandler(itemDB);

    @Test
    public void fetchDatabaseTest() {
       String expectedResult = "Apple";
        String result = itemDBHandler.fetchDatabase().get(0).getItemName();
        assertEquals(expectedResult, result);
    }

}