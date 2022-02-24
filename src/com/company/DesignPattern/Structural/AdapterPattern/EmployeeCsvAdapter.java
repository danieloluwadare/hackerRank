package com.company.DesignPattern.Structural.AdapterPattern;

public class EmployeeCsvAdapter implements Employee {

    private EmployeeCsv employeeCsv;

    public EmployeeCsvAdapter(EmployeeCsv employeeCsv) {
        this.employeeCsv = employeeCsv;
    }

    @Override
    public String getId() {
        return employeeCsv.getId();
    }

    @Override
    public String getFirstName() {
        return employeeCsv.givenName();
    }

    @Override
    public String getLastName() {
        return employeeCsv.getSurname();
    }

    @Override
    public String getEmail() {
        return employeeCsv.getEmailAddress();
    }
}
