package se.kth.iv350.POS.database;

import java.util.ArrayList;

public class CustomerDatabase {

    private ArrayList<CustomerDTO> customers = new ArrayList<CustomerDTO>();

    /**
     * Creates an instance of a fictional database, it represents three customers with id, and
     * discount in percentage of total price
     */

    public CustomerDatabase (){
        customers.add(new CustomerDTO("1", 10));
        customers.add(new CustomerDTO("2", 20));
        customers.add(new CustomerDTO("3", 30));
    }

    /**
     * Searches the customer database by an id represented as a string.
     * @param searchedID The string that is used as the search parameter
     * @return The <code>CustomerDTO</code> whose <code>customerID</code> matches searchedID
     */

    public CustomerDTO searchCustomerByID(String searchedID){

        for(int i = 0; i < customers.size(); i++)
            if (customers.get(i).getCustomerID().equals(searchedID))
                return customers.get(i);

        return null;
    }

    public ArrayList<CustomerDTO> getCustomers(){
        return this.customers;
    }

}
