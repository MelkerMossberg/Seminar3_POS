package se.kth.iv350.POS.tests;

import org.junit.Test;
import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.database.ItemDatabase;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class ItemDatabaseTest {

    ItemDatabase itemDatabase = new ItemDatabase();

    //Todo skiv test till itemDatabase
    @Test
    public void getItemsTest() throws Exception {
        String expectedResult = "Apple";
        String result = itemDatabase.getItems().get(0).getItemName();
        assertEquals(expectedResult, result);
    }
}
