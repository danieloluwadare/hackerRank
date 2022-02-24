package com.company.DesignPattern.Creational.Builder;

public class LunchOrderMain {
    public static void main(String[] args) {
        LunchOrder.Builder builder = new LunchOrder.Builder();
        LunchOrder lunchOrder = builder.setBeef("Cow meat").setBread("Yem yem bread").setEgg("egg").setTea("tea").build();
        System.out.println(lunchOrder.getBeef());
        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getEgg());
        System.out.println(lunchOrder.getTea());

    }
}
