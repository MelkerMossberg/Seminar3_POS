package se.kth.iv350.POS.model;

public class DiscountControl {

    public DiscountControl(){

    }

    public int calculateDiscount(PurchaseDTO purchase){
        int discount = purchase.getDiscount();
        double factor = ((100.0-discount)/100.0);
        double newPrice = (double) purchase.totalPrice * factor;
        return (int) newPrice;
    }

}
