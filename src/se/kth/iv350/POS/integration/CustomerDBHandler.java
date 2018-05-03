package se.kth.iv350.POS.integration;

import se.kth.iv350.POS.database.CustomerDTO;
import se.kth.iv350.POS.database.CustomerDatabase;

public class CustomerDBHandler {

    CustomerDatabase customerDatabase;
    public CustomerDBHandler(CustomerDatabase customerDB){
        this.customerDatabase = customerDB;
    }

    public CustomerDTO getIfValidCustomer (String customer){
        return customerDatabase.searchCustomerByID(customer);
    }
}
