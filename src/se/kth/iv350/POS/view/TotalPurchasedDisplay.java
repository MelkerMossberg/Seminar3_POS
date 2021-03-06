package se.kth.iv350.POS.view;
import se.kth.iv350.POS.model.TotalPurchasedObserver;

/**
 * Is a observer of "Total Purchased". It prints the updated value to the console.
 */
public class TotalPurchasedDisplay implements TotalPurchasedObserver {

    private int totalPurchased = 0;

    @Override
    public void updateTotalPurchased(int purchaseTotal) {
        calculateNewTotal(purchaseTotal);
    }

    private void calculateNewTotal(int purchaseTotal) {
        this.totalPurchased += purchaseTotal;
        System.out.println("\nTotal Purchased: " + this.totalPurchased);
    }

    public int getTotalPurchased(){
        return totalPurchased;
    }
}
