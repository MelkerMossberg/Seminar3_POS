package se.kth.iv350.POS.model;

/**
 * Interface for classes that observe when a purchased has been finalized.
 * It then updates the total purchased amount.
 */
public interface TotalPurchasedObserver {
    void updateTotalPurchased(int purchaseTotal);
}
