package se.kth.iv350.POS.database;

import java.util.ArrayList;

public class CustomerDatabase {

    ArrayList<CustomerDTO> customers = new ArrayList<CustomerDTO>();

    public CustomerDatabase (){
        customers.add(new CustomerDTO("1", 10));
        customers.add(new CustomerDTO("2", 20));
        customers.add(new CustomerDTO("3", 30));
    }

}
