/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.subarraytester;

/**
 *
 * @author hvins
 */
public class MaxSubarraySolver {

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     * Theoretical Complexity: O(n^2)
     *
     * Primitive operation count analysis:
     *  - Outer loop runs n times.
     *  - Inner loop runs (n - i) times on average → roughly n/2 times.
     *  - Each iteration performs a constant number of additions/comparisons.
     *  → Total operations ≈ c * (n * n/2) = O(n^2)
     */
    public static int bruteForceMaxSum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) { 
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += arr[j]; 
                if (currentSum > maxSum) { 
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * Theoretical Complexity: O(n)
     *
     * Complexity analysis:
     *  - Single loop that runs once through all n elements.
     *  - Each iteration performs a constant number of operations (add, compare, assign).
     *  → Total operations = c * n = O(n)
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        int maxSoFar = arr[0];
        int currentMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}

