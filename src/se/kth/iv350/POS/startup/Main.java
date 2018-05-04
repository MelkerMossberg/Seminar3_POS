package se.kth.iv350.POS.startup;

import se.kth.iv350.POS.controller.Controller;
import se.kth.iv350.POS.database.CustomerDatabase;
import se.kth.iv350.POS.database.ItemDatabase;
import se.kth.iv350.POS.integration.AccountingSystem;
import se.kth.iv350.POS.integration.CustomerDBHandler;
import se.kth.iv350.POS.integration.ItemDBHandler;
import se.kth.iv350.POS.model.Register;
import se.kth.iv350.POS.view.View;

/**
 * Contains the <code>main</code> method. Performs startup of the application
 */
public class Main {
    public static void main (String[] args){
        Register register = new Register();
        ItemDatabase itemDatabase = new ItemDatabase();
        CustomerDatabase customerDatabase = new CustomerDatabase();
        ItemDBHandler itemDBHandler = new ItemDBHandler(itemDatabase);
        CustomerDBHandler customerDBHandler = new CustomerDBHandler(customerDatabase);
        AccountingSystem accountingSystem = new AccountingSystem();
        Controller controller = new Controller(itemDBHandler, customerDBHandler, accountingSystem);
        View view = new View(controller);

    }
}
