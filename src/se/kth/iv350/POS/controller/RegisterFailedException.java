package se.kth.iv350.POS.controller;

public class RegisterFailedException extends Exception{

    public RegisterFailedException(String msg, Exception e){
        super(msg, e);
    }
}
