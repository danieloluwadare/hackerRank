package com.company.DesignPattern.behavioural.ChainOfResponsibility;

public class Ceo extends Handler {
    @Override
    public void handleRequest(Request request) {
        if(request.getRequestType().equalsIgnoreCase("Ceo")){
            System.out.println("Ceo can approve");
        }else {
            successor.handleRequest(request);
        }
    }
}
