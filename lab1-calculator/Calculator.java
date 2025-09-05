/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab1.calculator;

/**
 *
 * @author hvins
 */
public class Calculator {
    private double currentValue = 0;
    private String pendingOperator = "";
    private boolean isFirstInput = true;
    
    public void setOperand(double operand) {
        if (isFirstInput) {
            currentValue = operand;
            isFirstInput = false;
        } else {
            performPendingOperation(operand);
        }
    }
    
    public void setOperator(String operator) {
        this.pendingOperator = operator;
    }
    
    public void calculate() {
        pendingOperator = "";
    }
    
    public double getCurrentValue() {
        return currentValue;
    }
    
    private void performPendingOperation(double operand) {
        switch (pendingOperator) {
            case "+":
                currentValue += operand;
                break;
            case "-":
                currentValue -= operand;
                break;
            case "*":
                currentValue *= operand;
                break;
            case "/":
                if (operand == 0) {
                    throw new ArithmeticException("Divison by zero");
                }
                currentValue /= operand;
                break;
            default:
                currentValue = operand;
        }
    }
}
