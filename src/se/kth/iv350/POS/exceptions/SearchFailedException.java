package se.kth.iv350.POS.exceptions;

public class SearchFailedException extends Exception{

    /**
     * Error due to search String could not be matched in database.
     * @param msg
     */
    public SearchFailedException(String msg) {
        super(msg);
    }

}
