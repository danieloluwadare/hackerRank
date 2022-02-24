package com.company.DesignPattern.behavioural.ChainOfResponsibility;

public class Vp extends Handler {
    @Override
    public void handleRequest(Request request) {
        if(request.getRequestType().equalsIgnoreCase("vp")){
            System.out.println("Vp can approve");
        }else {
            successor.handleRequest(request);
        }
    }
}
