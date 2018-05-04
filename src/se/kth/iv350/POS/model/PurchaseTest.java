package se.kth.iv350.POS.model;

import org.junit.Test;
import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.database.ItemDatabase;
import se.kth.iv350.POS.integration.AccountingSystem;
import se.kth.iv350.POS.integration.ItemDBHandler;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PurchaseTest {

    Purchase purchase = new Purchase("1");
    ItemDatabase itemDatabase = new ItemDatabase();
    ItemDBHandler itemDBHandler = new ItemDBHandler(itemDatabase);
    AccountingSystem accountingSystem = new AccountingSystem();

    @Test
    public void getPurchaseData() throws Exception{

        ItemDTO item1 = new ItemDTO("1", 10, "Apple");

        purchase.addItem(item1);

        assertEquals("Apple", purchase.getPurchaseData().getItems().get(0).getItemName());
    }

    @Test
    public void addItemCorrect() throws  Exception{

        ItemDTO item = itemDBHandler.getIfValidItem("0");
        purchase.addItem(item);
        String result = purchase.getItems().get(0).getItemName();
        String expectedResult = "Apple";

        assertEquals(expectedResult, result);
    }


    @Test
    public void finalizeSale() throws  Exception{

        ArrayList<ItemDTO> testItems = new ArrayList<>();
        testItems.add(new ItemDTO("1", 10, "TestPro1"));
        testItems.add(new ItemDTO("2", 5, "TestPro2"));
        testItems.add(new ItemDTO("3", 15, "TestPro3"));

        for (ItemDTO item : testItems)
            purchase.addItem(item);

        int change = purchase.finalizeSale(30, accountingSystem);
        assertEquals(0, change);

    }


}