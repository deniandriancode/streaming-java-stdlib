/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package app.streaming_java_lib;

import java.util.*;
import java.util.stream.*;

class Employee {
    
    private long id;
    private String name;
    private double salary;

    public Employee(long id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return String.format("Employee[id=%dl, name=%s, salary=%f]", id, name, salary);
    }
}

/**
 *
 * @author deni
 */
public class Streaming_java_lib {
    
    private static final Employee[] arrayOfEmployees = {
        new Employee(1, "Jeff Bezos", 100000.0), 
        new Employee(2, "Bill Gates", 200000.0), 
        new Employee(3, "Mark Zuckerberg", 300000.0)
    };

    public static void main(String[] args) {
        List<Employee> listOfEmployees = Arrays.asList(arrayOfEmployees);
        Stream<Employee> stream01 = listOfEmployees.stream();
        Stream<Employee> stream02 = Stream.of(arrayOfEmployees);
        
        // some stream operation
        stream01.forEach(emp -> {
            emp.setSalary(emp.getSalary() + 1);
            System.out.println(emp.toString());
        });
        
        Integer[] nums = { 1, 2, 3, 4, 5 };
        Stream<Integer> numsStream = Stream.of(nums);
        List<Integer> squaredNums = numsStream
                .map(n -> n*n)
                .collect(Collectors.toList());
        
        for (Integer i : squaredNums) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        Integer[] nums2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<Integer> odd = Stream.of(nums2)
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
        for (Integer i : odd) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
