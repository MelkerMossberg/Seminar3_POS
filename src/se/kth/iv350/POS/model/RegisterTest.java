package se.kth.iv350.POS.model;

import org.junit.Test;
import se.kth.iv350.POS.database.ItemDTO;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RegisterTest {

    Purchase purchase = new Purchase("1");
    Register register = new Register();

    @Test
    public void getReceipt() {

        ArrayList<ItemDTO> testItems = new ArrayList<>();
        testItems.add(new ItemDTO("1", 10, "TestPro1"));
        testItems.add(new ItemDTO("2", 5, "TestPro2"));
        testItems.add(new ItemDTO("3", 15, "TestPro3"));

        for (ItemDTO item : testItems)
            purchase.addItem(item);

        register.getReceipt(purchase.getPurchaseData(), 50, 30);


    }


}