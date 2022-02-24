package com.company.DesignPattern.Structural.BridgePattern.problem;

public class ProblemMain {
    public static void main(String[] args) {
        BlueCircle blueCircle = new BlueCircle();
        blueCircle.applyColor();
        BlueSquare blueSquare = new BlueSquare();
        blueSquare.applyColor();
    }
}
