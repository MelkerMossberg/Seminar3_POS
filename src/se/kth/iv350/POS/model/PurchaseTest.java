package se.kth.iv350.POS.model;

import org.junit.Test;
import se.kth.iv350.POS.database.ItemDTO;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PurchaseTest {

    @Test
    public void getPurchaseData() throws Exception{


        ItemDTO item1 = new ItemDTO("1", 10, "Apple");
        Purchase purchase = new Purchase("1");
        purchase.addItem(item1);

        assertEquals("Apple", purchase.getPurchaseData().getItems().get(0).getItemName());




    }
}