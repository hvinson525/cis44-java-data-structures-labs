/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matrix;

/**
 *
 * @author hvins
 */
public class Main {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(3, 3);
        Matrix m2 = new Matrix(3, 3);

        m1.populateRandom();
        m2.populateRandom();

        System.out.println("Matrix A:");
        System.out.println(m1);

        System.out.println("Matrix B:");
        System.out.println(m2);

        Matrix sum = m1.add(m2);
        System.out.println("A + B:");
        System.out.println(sum);

        Matrix product = m1.multiply(m2);
        System.out.println("A * B:");
        System.out.println(product);
    }
}
