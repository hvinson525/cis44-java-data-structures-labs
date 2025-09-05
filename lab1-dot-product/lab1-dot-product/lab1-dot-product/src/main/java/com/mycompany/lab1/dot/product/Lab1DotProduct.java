/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab1.dot.product;

/**
 *
 * @author hvins
 */
import java.util.Random;
import java.util.Scanner;
public class Lab1DotProduct {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Enter the length of the arrays: ");
        int n = scanner.nextInt();
        
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(100) + 1;
            b[i] = random.nextInt(100) + 1;
            c[i] = a[i] * b[i];
        }
        
        System.out.println("Array a: ");
        printArray(a);
        
        System.out.println("Array b: ");
        printArray(b);
        
        System.out.println("Array c: ");
        printArray(c);
    }
    
    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
