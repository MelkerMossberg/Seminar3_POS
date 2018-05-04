package se.kth.iv350.POS.model;

public class DiscountControl {

    public DiscountControl(){ }

    /**
     * Calculates the discount from a given <code>PurchaseDTO</code>.
     * @param purchase Purchase contains <code>discount</code> and <code>totalPrice</code>, from which
     *                 the method calculate the <code>newPrice</code>.
     * @return Returns the new discounted price.
     */

    public int calculateDiscount(PurchaseDTO purchase){
        int discount = purchase.getDiscount();
        double factor = ((100.0-discount)/100.0);
        double newPrice = (double) purchase.totalPrice * factor;
        return (int) newPrice;
    }

}
