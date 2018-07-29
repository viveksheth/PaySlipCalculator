package com.payslipcalc;

public class PaySlipCalculatorException extends Exception {

    private String message;

    public PaySlipCalculatorException(String message){
        super(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
