package se.kth.iv350.POS.controller;

import se.kth.iv350.POS.database.DatabaseFailureException;

public class OperationFailedException extends Throwable {
    public OperationFailedException(String s, DatabaseFailureException dbExc) {
        super(s, dbExc);
    }
}
