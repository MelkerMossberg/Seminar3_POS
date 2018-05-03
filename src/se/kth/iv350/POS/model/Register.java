package se.kth.iv350.POS.model;

import se.kth.iv350.POS.integration.ReceiptPrinter;

public class Register {
    private ReceiptPrinter receiptPrinter;
    private Receipt receipt;

    public Register(){
        this.receiptPrinter = new ReceiptPrinter();
    }

    public void getReceipt(PurchaseDTO purchaseDTO, int amountPayed, int change){
        receipt = new Receipt(purchaseDTO, amountPayed, change);
        receiptPrinter.PrintReceipt(receipt);
    }
}
