package com.example.views;

import java.util.ArrayList;

import com.example.models.Employee;

public class EmployeeView {
    
    public void printEmployees(ArrayList<Employee> employees) {
        for(Employee emp: employees) {
            ConsoleView console = new ConsoleView();
            console.print(
                emp.getId() + ", " +
                emp.getName() + ", " + 
                emp.getCity() + ", " + 
                emp.getSalary()
            );
        }
    }

    public Employee createEmployee() {
        ConsoleView console = new ConsoleView();
        Employee emp = new Employee();
        emp.setName(console.input("Name: "));
        emp.setCity(console.input("City: "));
        emp.setSalary(Integer.parseInt(console.input("Salary: ")));
        return emp;
    }

    public Employee editEmployee(ArrayList<Employee> employees) {
        ConsoleView console = new ConsoleView();
        int id = Integer.parseInt(console.input("Id: "));
        for(Employee emp: employees) {
            if (emp.getId() == id) {
                emp.setName(console.input("Name: "));
                emp.setCity(console.input("City: "));
                emp.setSalary(Integer.parseInt(console.input("Salary: ")));
                return emp;
            }
        }
        return null;
        
    }

    public int deleteEmployee(ArrayList<Employee> employees) {
        ConsoleView console = new ConsoleView();
        int id = Integer.parseInt(console.input("Id: "));
        for(Employee emp: employees) {
            if (emp.getId() == id) {
                employees.remove(emp);
                return id;
            }
        }
        return -1;
    }
}
