/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matrix;

/**
 *
 * @author hvins
 */
import java.util.Random;

public class Matrix {
    private int[][] data;
    
    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows and columns must be positive integers");
        }
        data = new int[rows][cols];
    }
    
    public Matrix(int[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new IllegalArgumentException("Invalid matrix data");
        }
        
        this.data = new int[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            if (data[i].length != data[0].length) {
                throw new IllegalArgumentException("All rows must have the same number of columns");
            }
            for (int j = 0; j < data[0].length; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }
    
    public void populateRandom() {
        Random rand = new Random();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = rand.nextInt(10) + 1;
            }
        }
    }
    
    public Matrix add(Matrix other) {
        if (other == null || data.length != other.data.length || data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition");
        }
        
        int rows = data.length;
        int cols = data[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = data[i][j] + other.data[i][j];
            }
        }
        
        return new Matrix(result);
    }
    
    public Matrix multiply(Matrix other) {
        if (other == null || data[0].length != other.data.length) {
            throw new IllegalArgumentException("Invalid dimensions for matrix multiplication");
        }
        
        int rows = data.length;
        int cols = other.data[0].length;
        int common = data[0].length;
        int[][] result = new int [rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < common; k++) {
                    result[i][j] += data[i][k] * other.data[k][j];
                }
            }
        }
        
        return new Matrix(result);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (int[] row : data) {
            for (int val : row) {
                sb.append(String.format("%4d", val));
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    public int getRows() {
        return data.length;
    }
    
    public int getCols() {
        return data[0].length;
    }
}
