package com.company.DesignPattern.Structural.AdapterPattern;

import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {
     public List<Employee> getListOfEmployee(){
         List<Employee> employees = new ArrayList<>();
         Employee employee = new EmployeeDatabase("1","one","das", "r@java");
         employees.add(employee);

//         Now we want to add Another Employee but its is not a database employee lets call it EmployeeCsv
//         We have to create an adapter to convert EmployeeCsv to employeeDatabase
         EmployeeCsv employeeCsv = new EmployeeCsv("1;two;second;two@java");
         employees.add(new EmployeeCsvAdapter(employeeCsv));

         return employees;
     }
}
