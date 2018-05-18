package se.kth.iv350.POS.tests;

import se.kth.iv350.POS.controller.Controller;
import se.kth.iv350.POS.controller.OperationFailedException;
import se.kth.iv350.POS.controller.RegisterFailedException;
import se.kth.iv350.POS.model.DatabaseFailureException;
import se.kth.iv350.POS.database.ItemDatabase;
import se.kth.iv350.POS.integration.AccountingSystem;
import se.kth.iv350.POS.integration.CustomerDBHandler;
import se.kth.iv350.POS.integration.ItemDBHandler;
import se.kth.iv350.POS.model.Purchase;
import se.kth.iv350.POS.model.PurchaseDTO;
import se.kth.iv350.POS.model.TotalPurchasedObserver;

import static org.junit.Assert.*;

public class ControllerTest {

    AccountingSystem accountingSystem = new AccountingSystem();
    CustomerDBHandler customerDBHandler;
    ItemDatabase itemDB = new ItemDatabase();
    ItemDBHandler itemDBHandler = new ItemDBHandler(itemDB);
    Controller controller = new Controller(itemDBHandler, customerDBHandler, accountingSystem);
    private TotalPurchasedObserver totalPurchaseObserver;
    private Purchase purchase;


    @org.junit.Test
    public void startNewSale() throws OperationFailedException, RegisterFailedException {
        controller.startNewSale();
        PurchaseDTO result = controller.registerItem("0", "ID");
        assertEquals("Apple", result.getItems().get(0).getItemName());
    }


    @org.junit.Test
    public void RegisterItemIDTest() throws OperationFailedException, RegisterFailedException {
        controller.startNewSale();
        try{
            String result = controller.registerItem("0", "ID").getItems().get(0).getItemName();
            String expectedResult = "Apple";
            assertEquals(expectedResult, result);
        }catch (DatabaseFailureException exc){
            throw new OperationFailedException("Failed to register.", exc);
        }
    }

    @org.junit.Test
    public void RegisterItemNameTest() throws OperationFailedException, RegisterFailedException {
        controller.startNewSale();
        try{
            int result = controller.registerItem("Apple", "Name").getItems().get(0).getItemPrice();
            int expectedResult = 10;
            assertEquals(expectedResult, result);
        }catch (DatabaseFailureException exc){
            throw new OperationFailedException("Failed to register.", exc);
        }
    }

    @org.junit.Test (expected=OperationFailedException.class)
    public void OperationFailedExceptionTest() throws OperationFailedException, RegisterFailedException {
        controller.startNewSale();
        try{
            PurchaseDTO result = controller.registerItem("5", "ID");
        }catch (DatabaseFailureException exc){
            throw new OperationFailedException("Failed to register.", exc);
        }
    }

    @org.junit.Test (expected=RegisterFailedException.class)
    public void RegisterFailedExceptionIDTest() throws OperationFailedException, RegisterFailedException {
        controller.startNewSale();
        PurchaseDTO result = controller.registerItem("99", "ID");
    }

    @org.junit.Test (expected=RegisterFailedException.class)
    public void RegisterFailedExceptionNameTest() throws OperationFailedException, RegisterFailedException {
        controller.startNewSale();
        PurchaseDTO result = controller.registerItem("Bazooka", "Name");
    }

    @org.junit.Test
    public void paymentTest() throws OperationFailedException, RegisterFailedException {
        controller.startNewSale();
        try{
            int result = controller.registerItem("Apple", "Name").getItems().get(0).getItemPrice();
            int expectedResult = 10;
            assertEquals(expectedResult, result);
        }catch (DatabaseFailureException exc){
            throw new OperationFailedException("Failed to register.", exc);
        }
        int change = controller.payment(10);
        assertEquals(0, change);

    }


}