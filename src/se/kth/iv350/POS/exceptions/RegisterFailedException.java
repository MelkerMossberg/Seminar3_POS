package se.kth.iv350.POS.exceptions;

public class RegisterFailedException extends Exception{

    /**
     * Error has occured due to item not found in database. User is notified.
     * @param msg
     * @param e
     */
    public RegisterFailedException(String msg, Exception e){
        super(msg, e);
    }
}
