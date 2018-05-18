package se.kth.iv350.POS.model;

public class DatabaseFailureException extends IllegalArgumentException {

    public DatabaseFailureException(String msg){
        super(msg);
    }
}
