package se.kth.iv350.POS.integration;

import org.junit.Test;
import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.model.Purchase;
import se.kth.iv350.POS.model.Receipt;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ReceiptPrinterTest {

    Purchase purchase = new Purchase("1");
    Receipt receipt;
    ReceiptPrinter receiptPrinter = new ReceiptPrinter();

    @Test
    public void printReceipt() {

        ArrayList<ItemDTO> testItems = new ArrayList<>();
        testItems.add(new ItemDTO("1", 10, "TestPro1"));
        testItems.add(new ItemDTO("2", 5, "TestPro2"));
        testItems.add(new ItemDTO("3", 15, "TestPro3"));

        for (ItemDTO item : testItems)
            purchase.addItem(item);

        receipt = new Receipt(purchase.getPurchaseData(), 50, 20);
        receiptPrinter.PrintReceipt(receipt);

    }
}