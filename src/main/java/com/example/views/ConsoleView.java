package com.example.views;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public String showMainMenuAndGetChoice() {
        System.out.println("1. Dolgozók");
        System.out.println("2. Dolgozó hozzáadás");
        System.out.println("3. Dolgozó módosítás");
        System.out.println("4. Dolgozó törlés");
        System.out.println("5. Kilepés");
        return scanner.nextLine().trim();
    }

    public String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public void print(String message) {
        System.out.println(message);
    }
}
