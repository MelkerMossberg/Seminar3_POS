package se.kth.iv350.POS.integration;

import se.kth.iv350.POS.model.Receipt;

public class ReceiptPrinter {

    public void PrintReceipt(Receipt receipt){
        for (int i = 0; i < receipt.getUniqueItems().size(); i++){
            System.out.print("id: " + receipt.getUniqueItems().get(i).getItemDTO().getID() + "\t");
            System.out.print("amount: " + receipt.getUniqueItems().get(i).getAmount() + "\t");
            System.out.print(receipt.getUniqueItems().get(i).getItemDTO().getItemName() + "\t");
            System.out.print("Price: " + (receipt.getUniqueItems().get(i).getItemDTO().getItemPrice() *
                receipt.getUniqueItems().get(i).getAmount()));
            System.out.println();

        }
        System.out.println();
        System.out.println("Total price: " + receipt.getTotalPrice());
        System.out.println("Amount payed: " + receipt.getAmountPayed());
        System.out.println("Change: " + receipt.getChange());
    }
}
