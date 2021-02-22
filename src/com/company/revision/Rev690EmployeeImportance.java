package com.company.revision;

/**
 * You are given a data structure of employee information, which includes the employee's unique id,
 * their importance value and their direct subordinates' id.
 *
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3.
 * They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]],
 * and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1,
 * the relationship is not direct.
 *
 * Now given the employee information of a company, and an employee id, you need to return the total importance value of
 * this employee and all their subordinates.
 *
 * Example 1:
 *
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 *
 *
 * Note:
 *
 * One employee has at most one direct leader and may have several subordinates.
 * The maximum number of employees won't exceed 2000.
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rev690EmployeeImportance {


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
        getImportance2(employees,1);

    }

    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map = new HashMap<>();
        for(Employee employee : employees)
            map.put(employee.id,employee);

        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        int importance = 0;
        while(!queue.isEmpty()){
            Employee currentEmployee = queue.poll();
            importance += currentEmployee.importance;
            for(int subordinate : currentEmployee.subordinates)
                queue.add(map.get(subordinate));

        }
        System.out.println(importance);
        return importance;
    }

    public static int getImportance2(List<Employee> employees, int id) {
        Map<Integer,Employee> map = new HashMap<>();
        for(Employee employee : employees)
            map.put(employee.id,employee);
        int importance = dfsGetImportance(map,id);
        System.out.println(importance);
        return importance;
    }

    public static int dfsGetImportance(Map<Integer,Employee> map, int id){
        Employee employee = map.get(id);
        int importance = employee.importance;
        for(int subOrdinatesId : employee.subordinates)
            importance+=dfsGetImportance(map,subOrdinatesId);
        return importance;
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
