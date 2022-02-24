package com.company.DesignPattern.Structural.BridgePattern;

public class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print(getShapeName());
        System.out.print(" >>>  ");
        color.applyColor();
        System.out.println();

    }

    @Override
    public String getShapeName() {
        return "SQUARE";
    }
}
