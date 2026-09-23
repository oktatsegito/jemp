package com.example.controllers;

import java.util.ArrayList;

import com.example.models.DataService;
import com.example.models.Employee;
import com.example.views.ConsoleView;
import com.example.views.EmployeeView;

public class MainController {
    private final ConsoleView console;
    private final EmployeeView employeeView;
    private final DataService dataService;
    private boolean isRuning = true;

    public MainController(ConsoleView console, DataService dataService) {
        this.console = console;
        this.employeeView = new EmployeeView();
        this.dataService = dataService;
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
                ArrayList<Employee> employees = dataService.getEmployees();
                employeeView.printEmployees(employees);
                break;
            case "2":
                Employee emp = employeeView.createEmployee();                  
                dataService.insertEmployee(emp);
                break;
            case "3":
                Employee updatedEmp = employeeView.editEmployee(dataService.getEmployees());
                dataService.updateEmployee(updatedEmp);
                break;
            case "4":
                int id = employeeView.deleteEmployee(dataService.getEmployees());
                dataService.deleteEmployee(id);
                break;
            case "5":
                isRuning = false;
                break;
        }
    }

}
