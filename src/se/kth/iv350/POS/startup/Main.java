package se.kth.iv350.POS.startup;

import se.kth.iv350.POS.controller.Controller;
import se.kth.iv350.POS.database.ItemDatabase;
import se.kth.iv350.POS.integration.ItemDBHandler;
import se.kth.iv350.POS.model.Register;
import se.kth.iv350.POS.view.View;
//Erik kommentar2
//Melker kommentar
public class Main {
    public static void main (String[] args){

        Register register = new Register();
        ItemDatabase itemDatabase = new ItemDatabase();
        ItemDBHandler itemDBHandler = new ItemDBHandler(itemDatabase);
        Controller controller = new Controller(itemDBHandler);
        View view = new View(controller);



        // Start new sale



    }
}
