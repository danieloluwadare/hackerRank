package com.company.DesignPattern.Creational.Singlenton;

public class SingletonMain {

    public static void main(String[] args) {
        DbSingleton dbSingleton = DbSingleton.getInstance();
        System.out.println(dbSingleton);
        DbSingleton dbSingleton2 = DbSingleton.getInstance();
        System.out.println(dbSingleton);
        System.out.println(dbSingleton==dbSingleton2);

        Person person = new Person("Azeez");

    }
}
