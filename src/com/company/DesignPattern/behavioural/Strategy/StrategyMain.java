package com.company.DesignPattern.behavioural.Strategy;

public class StrategyMain {

    public static void main(String[] args) {
        ValidationStrategy validationStrategy = new AmexValidationStrategy();
        CreditCard creditCard = new CreditCard(validationStrategy);
        creditCard.setCvv("256782920");
        creditCard.setPan("541671918u19819");
        creditCard.setPin("1994");
        System.out.println(creditCard.isValid());
    }
}
