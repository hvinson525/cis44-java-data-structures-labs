/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.subarraytester;

/**
 *
 * @author hvins
 */
import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        System.out.println("=== Maximum Subarray Sum: Brute-Force vs Kadane's ===\n");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            int[] arr = generateRandomArrayWithNegatives(n);

            timeAlgorithm("Brute-Force (O(n^2))", arr, MaxSubarraySolver::bruteForceMaxSum, n <= 10000); 
            
            timeAlgorithm("Kadane's (O(n))", arr, MaxSubarraySolver::kadanesAlgorithmMaxSum, true);
        }
    }

    /**
     * Measures execution time for an algorithm.
     * Uses a condition to skip brute-force on large n to prevent excessive runtime.
     */
    public static void timeAlgorithm(String name, int[] arr, java.util.function.ToIntFunction<int[]> algorithm, boolean shouldRun) {
        if (!shouldRun) {
            System.out.printf("%-25s : Skipped (too slow for large n)\n", name);
            return;
        }

        long start = System.nanoTime();
        int maxSum = algorithm.applyAsInt(arr);
        long end = System.nanoTime();
        double timeMs = (end - start) / 1_000_000.0;

        System.out.printf("%-25s : %10.3f ms   |  Max Sum = %d\n", name, timeMs, maxSum);
    }

    /**
     * Generates a random integer array that includes both positive and negative numbers.
     */
    public static int[] generateRandomArrayWithNegatives(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(2001) - 1000;
        }
        return arr;
    }
}

