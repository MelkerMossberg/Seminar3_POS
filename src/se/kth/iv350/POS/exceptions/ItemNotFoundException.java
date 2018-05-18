package se.kth.iv350.POS.exceptions;

public class ItemNotFoundException extends Exception{

    /**
     * Error due to search String could not be matched in database.
     * @param msg
     */
    public ItemNotFoundException(String msg){
        super(msg);
    }
}
