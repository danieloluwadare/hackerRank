package com.company.DesignPattern.Structural.BridgePattern;

public class BridgePatternMain {
    public static void main(String[] args) {

        Color blue = new Blue();
        Color green = new Green();

        Shape square = new Square(blue);
        Shape circle = new Circle(green);

        square.applyColor();
        circle.applyColor();

        square = new Square(green);
        circle = new Circle(blue);

        square.applyColor();
        circle.applyColor();



//        Tobi tobi = new Tobi();
//        tobi.eat();
    }
}
