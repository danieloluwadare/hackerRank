package com.company.DesignPattern.Structural.AdapterPattern;

public class EmployeeCsv {
    private String employeeDetails;

    public EmployeeCsv(String employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public String getId(){
        return employeeDetails.split(";")[0];
    }

    public String getSurname(){
        return employeeDetails.split(";")[1];
    }

    public String givenName(){
        return employeeDetails.split(";")[2];
    }

    public String getEmailAddress(){
        return employeeDetails.split(";")[3];
    }
}
