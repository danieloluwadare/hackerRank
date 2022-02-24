package com.company.DesignPattern.Structural.AdapterPattern;

public class AdapterPatternMain {
    public static void main(String[] args) {
        EmployeeClient employeeClient = new EmployeeClient();
        System.out.print(employeeClient.getListOfEmployee());
    }
}
