package se.kth.iv350.POS.database;

import java.sql.SQLException;

public class DatabaseFailureException extends IllegalArgumentException {

    DatabaseFailureException(){
        super();
    }
}
