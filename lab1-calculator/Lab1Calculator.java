/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab1.calculator;

/**
 *
 * @author hvins
 */
import java.util.Scanner;

public class Lab1Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        
        System.out.println("Simple Calculator");
        System.out.println("Enter numbers and operations one at a time");
        System.out.println("Type 'exit' to quit");
        
        while (true) {
            System.out.print(">");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Calculator exited");
                break;
        }
        
        try {
            if (isOperator(input)) {
                calculator.setOperator(input);
            } else if (input.equals("=")) {
                calculator.calculate();
            } else {
                double value = Double.parseDouble(input);
                calculator.setOperand(value);
            }
            
            System.out.println("Screen: " + calculator.getCurrentValue());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        }
        
        scanner.close();
    }
    
    private static boolean isOperator(String input) {
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/");
    }
}
