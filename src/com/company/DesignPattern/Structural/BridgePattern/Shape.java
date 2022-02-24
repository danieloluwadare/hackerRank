package com.company.DesignPattern.Structural.BridgePattern;

public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract public void applyColor();
    abstract public String getShapeName();

}
