package com.company.DesignPattern.behavioural.ChainOfResponsibility;

public class Director extends Handler {
    @Override
    public void handleRequest(Request request) {
        if(request.getRequestType().equalsIgnoreCase("director")){
            System.out.println("Director can approve");
        }else {
            successor.handleRequest(request);
        }
    }
}
