package se.kth.iv350.POS.model;

import se.kth.iv350.POS.integration.ReceiptPrinter;

public class Register {

    private static final Register REGISTER = new Register();
    private ReceiptPrinter receiptPrinter = new ReceiptPrinter();

    private Register(){
    }

    public static Register getRegister(){
        return REGISTER;
    }

    /**
     * Creates an instance of <code>Receipt</code> and calls the function <code>PrintReceipt</code> in
     * <code>ReceiptPrinter</code>.
     * @param purchaseDTO The <code>PurchaseDTO</code> with which the function creates the receipt.
     * @param amountPayed The amount payed by the customer.
     * @param change The change given to the customer.
     */

    public void getReceipt(PurchaseDTO purchaseDTO, int amountPayed, int change){
        Receipt receipt = new Receipt(purchaseDTO, amountPayed, change);
        receiptPrinter.PrintReceipt(receipt);
    }
}
