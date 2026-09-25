package com.example.controllers;

import java.util.ArrayList;

import com.example.models.EmployeeService;
import com.example.models.Employee;
import com.example.views.ConsoleView;
import com.example.views.EmployeeView;

public class MainController {
    private final ConsoleView console;
    private final EmployeeView employeeView;
    private final EmployeeService employeeService;
    private boolean isRuning = true;

    public MainController(ConsoleView console, EmployeeService employeeService) {
        this.console = console;
        this.employeeView = new EmployeeView();
        this.employeeService = employeeService;
    }

    public void start() {
        while(isRuning) {
            String choice = console.showMainMenuAndGetChoice();
            handleMenuChoice(choice);
        }
    }

    public void handleMenuChoice(String choice) {
        switch(choice) {
            case "1":
                ArrayList<Employee> employees = employeeService.getEmployees();
                employeeView.printEmployees(employees);
                break;
            case "2":
                Employee emp = employeeView.createEmployee();                  
                employeeService.insertEmployee(emp);
                break;
            case "3":
                Employee updatedEmp = employeeView.editEmployee(employeeService.getEmployees());
                employeeService.updateEmployee(updatedEmp);
                break;
            case "4":
                int id = employeeView.deleteEmployee(employeeService.getEmployees());
                employeeService.deleteEmployee(id);
                break;
            case "5":
                isRuning = false;
                break;
        }
    }

}
