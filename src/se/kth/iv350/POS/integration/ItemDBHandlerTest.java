package se.kth.iv350.POS.integration;

import org.junit.Test;
import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.database.ItemDatabase;

import static org.junit.Assert.*;

public class ItemDBHandlerTest {

    ItemDatabase itemDB = new ItemDatabase();
    ItemDBHandler itemDBHandler = new ItemDBHandler(itemDB);

    @Test
    public void getIfValidItem() {
        ItemDTO expectedResult =itemDB.getItemDTO(0);
        ItemDTO result = itemDBHandler.getIfValidItem("0");
        assertEquals(expectedResult, result);
    }

    @Test
    public void getIfValidItemNullInput() {
        ItemDTO expectedResult = null;
        ItemDTO result = itemDBHandler.getIfValidItem("10");
        assertEquals(expectedResult, result);
    }
}