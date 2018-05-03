package se.kth.iv350.POS.database;

public class CustomerDTO {

    final String customerID;
    final int discount;

    /**
     * Creates an instance.
     * @param customerID The customer id in the newly created instance
     * @param discount The discount rate for the newly created instance, represented in percentage of the total price
     */

    public CustomerDTO (String customerID, int discount){
        this.customerID = customerID;
        this.discount = discount;
    }

    public String getCustomerID(){
        return this.customerID;
    }

    public int getDiscount(){
        return this.discount;
    }

}
