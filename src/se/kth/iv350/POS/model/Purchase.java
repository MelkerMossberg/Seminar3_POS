package se.kth.iv350.POS.model;

import se.kth.iv350.POS.database.ItemDTO;
import se.kth.iv350.POS.integration.AccountingSystem;
import se.kth.iv350.POS.integration.ItemDBHandler;

import java.util.ArrayList;

public class Purchase {

    final String purchaseID;
    private ArrayList<ItemDTO> items;
    private ArrayList<UniqueItem> uniqueItems = new ArrayList<>();
    private int totalPrice;
    private int amountPayed;
    private int change;
    private int discount;
    private TotalPurchasedObserver totalPurchasedObserver;

    /**
     * Creates a new instance of purchase, with an ID, a new, empty list of items and a total price
     * @param id The ID of the purchase
     */

    public Purchase (String id){
        this.purchaseID = id;
        this.items = new ArrayList<ItemDTO>();
        this.totalPrice = 0;
    }

    /**
     * Creates a <code>PurchaseDTO</code> from an instance of <code>Purchase</code>. The <code>PurchaseDTO</code>
     * contains a list of items, a list of unique items, the total price, an ID, and the disocunt.
     * @return Returns the created <code>PurchaseDTO</code>.
     */

    public PurchaseDTO getPurchaseData(){
        PurchaseDTO purchase = new PurchaseDTO(this.purchaseID, this.items, this.totalPrice, this.uniqueItems, this.discount);
        return purchase;
    }

    /**
     * Adds a validated <code>ItemDTO</code> to the calling object's list of items.
     * @param validItem A validated <code>ItemDTO</code>.
     */

    public void addItem(ItemDTO validItem) {
        this.items.add(validItem);

        for(UniqueItem item : uniqueItems)
            if (item.getItemDTO().getID().equals(validItem.getID())){
                item.incrementAmount();
                updateTotal();
                return;
            }
        uniqueItems.add(new UniqueItem(validItem));
        updateTotal();
    }

    private void updateTotal() {
        int newTotal = 0;
        for (ItemDTO item : this.items)
            newTotal += item.getItemPrice();
        this.totalPrice = newTotal;
    }

    public ArrayList<UniqueItem> getUniqueItems (){
        return this.uniqueItems;
    }

    /**
     * Creates an instance of <code>Register</code> and calls the function <code>getReceipt</code> in
     * <code>Register</code>. It also calls the function <code>updateAccounting</code> in
     * <code>AccountingSystem</code>, but we haven't programmed this function, it was left empty.
     * @param amount The amount payed by the customer.
     * @return Returns the calculated change of the purchase.
     */

    public int calculateChange(int amount){
        this.amountPayed = amount;
        this.change = this.amountPayed - this.totalPrice;
        return this.change;
    }

    public void finalizeSale(AccountingSystem accountingSystem){
        Register register = new Register();
        register.getReceipt(getPurchaseData(), amountPayed, change);
        accountingSystem.updateAccounting(getPurchaseData());
        notifyObserver();
    }


    public ArrayList<ItemDTO> getItems(){
        return this.items;
    }

    /**
     * Sets a new total price.
     * @param newPrice The new price to be set.
     * @return returns a purchase DTO generated from the calling object.
     */

    public PurchaseDTO setNewPrice (int newPrice){
        this.totalPrice = newPrice;
        return getPurchaseData();
    }

    public void setNewDiscount(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void addTotalPurshasedObserver(TotalPurchasedObserver observer){
        this.totalPurchasedObserver = observer;
    }

    private void notifyObserver(){
        this.totalPurchasedObserver.updateTotalPurchased(this.totalPrice);
    }

}


