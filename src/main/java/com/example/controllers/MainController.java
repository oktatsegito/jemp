package com.example.controllers;

import java.util.ArrayList;

import com.example.models.EmployeeService;
import com.example.models.Mariadb;
import com.example.models.Sqlite;
import com.example.models.Config;
import com.example.models.Employee;
import com.example.views.ConsoleView;
import com.example.views.EmployeeView;

public class MainController {
    private final ConsoleView console;
    private final EmployeeView employeeView;
    private EmployeeService employeeService;
    private boolean isRuning = true;

    public MainController() {
        this.console = new ConsoleView();
        this.employeeView = new EmployeeView();
        Config config = new Config();
        String dialect = config.getProperty("dealect");
        if(dialect.equals("sqlite")) {
            this.employeeService = new EmployeeService(new Sqlite());
        } if(dialect.equals("mariadb")) {
            this.employeeService = new EmployeeService(new Mariadb());
        } else {
            this.employeeService = new EmployeeService(new Sqlite());
        }
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
