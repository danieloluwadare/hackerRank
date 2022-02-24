package com.company.DesignPattern.Structural.BridgePattern;

public abstract class Man {

    abstract public String getFoodByWhatEverCutlery();
    abstract public String drinkWaterFromWhateverCup();

    protected void eat(){
        String food = getFoodByWhatEverCutlery();//hand or spoon , fork
        System.out.println("eat food from "+ food +" through the mouth");
        String water = drinkWaterFromWhateverCup();
        System.out.println("drink water from " + water +" mouth");

    }

}
