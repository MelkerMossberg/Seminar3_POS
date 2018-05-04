package se.kth.iv350.POS.database;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class CustomerDatabaseTest {


    CustomerDatabase customerDB = new CustomerDatabase();

    @Test
    public void searchCustomerByIDCorrectValues() {
        CustomerDTO expectedResult = customerDB.customers.get(0);
        CustomerDTO result = customerDB.searchCustomerByID("1");
        assertEquals(expectedResult, result);
    }

    @Test
    public void searchCustomerByIDInvalidValues() {
        CustomerDTO expectedResult = null;
        CustomerDTO result = customerDB.searchCustomerByID("7");
        assertEquals(expectedResult, result);
    }
}