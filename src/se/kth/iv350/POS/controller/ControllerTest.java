package se.kth.iv350.POS.controller;

import se.kth.iv350.POS.database.ItemDatabase;
import se.kth.iv350.POS.integration.AccountingSystem;
import se.kth.iv350.POS.integration.ItemDBHandler;
import se.kth.iv350.POS.model.Purchase;
import se.kth.iv350.POS.model.PurchaseDTO;

import static org.junit.Assert.*;

public class ControllerTest {

    AccountingSystem accountingSystem;

    @org.junit.Test
    public void startNewSale() {
        ItemDatabase itemDB = new ItemDatabase();
        ItemDBHandler itemDBHandler = new ItemDBHandler(itemDB);
        Controller controller = new Controller(itemDBHandler, accountingSystem);
        controller.startNewSale();
        PurchaseDTO result = controller.registerItem("0");

        assertEquals("Apple", result.getItems().get(0).getItemName());
    }
}