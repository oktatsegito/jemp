package com.example;

import com.example.controllers.MainController;
import com.example.models.DataService;
import com.example.models.Sqlite;
import com.example.views.ConsoleView;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dolgozók...");

        MainController controller = new MainController(
            new ConsoleView(), 
            new DataService(new Sqlite())
        );
        controller.start();
    }
}