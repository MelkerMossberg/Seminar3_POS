package se.kth.iv350.POS.tests;

import org.junit.Test;
import se.kth.iv350.POS.database.CustomerDTO;
import se.kth.iv350.POS.database.CustomerDatabase;
import se.kth.iv350.POS.integration.CustomerDBHandler;

import static org.junit.Assert.*;

public class CustomerDBHandlerTest {

    CustomerDatabase customerDB = new CustomerDatabase();
    CustomerDBHandler customerDBHandler = new CustomerDBHandler(customerDB);

    @Test
    public void getDiscountIfValid() {
        int result = customerDBHandler.getDiscountIfValid("1");
        int expectedResult = 10;
        assertEquals(expectedResult, result);
    }

    @Test
    public void getDiscountIfInvalid() {
        //TODO: Create exeption for invalid customerID
    }
}