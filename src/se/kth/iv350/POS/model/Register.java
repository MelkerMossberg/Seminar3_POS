package se.kth.iv350.POS.model;

import se.kth.iv350.POS.integration.ReceiptPrinter;

public class Register {
    private ReceiptPrinter receiptPrinter = new ReceiptPrinter();
    private Receipt receipt;

    public Register(){
    }

    public void getReceipt(PurchaseDTO purchaseDTO, int amountPayed, int change){
        receipt = new Receipt(purchaseDTO, amountPayed, change);
        receiptPrinter.PrintReceipt(receipt);
    }
}
