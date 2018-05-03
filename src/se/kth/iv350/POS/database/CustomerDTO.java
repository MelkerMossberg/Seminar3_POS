package se.kth.iv350.POS.database;

public class CustomerDTO {

    final String customerID;
    final int discount;

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
