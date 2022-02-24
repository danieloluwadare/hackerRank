package com.company.DesignPattern.behavioural.ChainOfResponsibility;

import java.util.List;

public class ChainOfResponsibilityMain {
    public static void main(String[] args) {
        Director director = new Director();
        Vp vp = new Vp();
        Ceo ceo = new Ceo();

        director.setSuccessor(vp);
        vp.setSuccessor(ceo);

        Request request = new Request("vp",2.00);
        director.handleRequest(request);

        request = new Request("ceo",2.00);
        director.handleRequest(request);

        request = new Request("director",2.00);
        director.handleRequest(request);

        System.out.println("okay now \n whatever");

    }
}
