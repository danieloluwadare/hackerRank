package com.company.DesignPattern.behavioural.Strategy;

public class AmexValidationStrategy implements ValidationStrategy {
    @Override
    public boolean isValid(CreditCard creditCard) {
        if(creditCard.getPan().length() % 2 == 0)
            return true;

        return false;
    }
}
