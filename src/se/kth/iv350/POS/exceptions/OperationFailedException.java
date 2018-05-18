package se.kth.iv350.POS.exceptions;

/**
 * Error has occurred due to unchecked critical database failure. Is not explained to user.
 */
public class OperationFailedException extends Throwable {
    public OperationFailedException(String s, DatabaseFailureException dbExc) {
        super(s, dbExc);
    }
}
