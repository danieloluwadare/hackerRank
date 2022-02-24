package com.company.DesignPattern.behavioural.Strategy;

public class CreditCard {
    private String  cvv;
    private String pan;
    private String pin;
    private ValidationStrategy validationStrategy;

    public CreditCard(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public boolean isValid(){
        return validationStrategy.isValid(this);
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }


}
