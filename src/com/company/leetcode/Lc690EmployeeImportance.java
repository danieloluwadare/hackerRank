package com.company.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lc690EmployeeImportance {

    public static void main(String[] args) {
//        Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
        List<Employee> employees = new ArrayList<>();
        List<Integer> list = IntStream.of(new int []{1,2}).boxed()
                .collect(Collectors.toList());
        employees.add(new Employee(1,5, IntStream.of(new int []{2,3}).boxed()
                .collect(Collectors.toList())));
        employees.add(new Employee(2,3, new ArrayList<>()));
        employees.add(new Employee(3,3, new ArrayList<>()));

        getImportance(employees,1);

    }

    public static int getImportance(List<Employee> employees, int id) {
        if(id==0 || employees==null || employees.size()==0)
            return 0;
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee : employees)
            map.put(employee.id,employee);

        int sumOfImportanceValue = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        while (!queue.isEmpty()){
            int eId = queue.poll();
            Employee employee = map.get(eId);
            sumOfImportanceValue += employee.importance;
            queue.addAll(employee.subordinates);
        }
        System.out.println(sumOfImportanceValue);
        return sumOfImportanceValue;
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    };
}
