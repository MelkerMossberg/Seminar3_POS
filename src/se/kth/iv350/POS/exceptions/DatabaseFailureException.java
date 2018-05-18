package se.kth.iv350.POS.exceptions;

public class DatabaseFailureException extends IllegalArgumentException {

    /**
     * An error has occurred due to item not being found in database.
     * @param msg Message about what item was searched is stored in log-file. Not printed to user.
     */
    public DatabaseFailureException(String msg){
        super(msg);
    }
}
