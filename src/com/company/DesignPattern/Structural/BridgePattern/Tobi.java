package com.company.DesignPattern.Structural.BridgePattern;

public class Tobi extends Man {


    @Override
    public String getFoodByWhatEverCutlery() {
        return "SPOON";
    }

    @Override
    public String drinkWaterFromWhateverCup() {
        return "GLASS_CUP";
    }
}
