/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sortingtester;

/**
 *
 * @author hvins
 */
import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000};

        System.out.println("=== The Sorting Race: Empirical Analysis ===\n");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            int[] average = generateRandomArray(n);
            int[] best = generateSortedArray(n);
            int[] worst = generateReverseSortedArray(n);

            runAndTimeAllSorts(average, "Average Case");
            runAndTimeAllSorts(best, "Best Case");
            runAndTimeAllSorts(worst, "Worst Case");
        }
    }

    public static void runAndTimeAllSorts(int[] original, String caseType) {
        System.out.println("\n" + caseType + ":");

        timeAlgorithm("Selection Sort", original, SortingAlgorithms::selectionSort);
        timeAlgorithm("Insertion Sort", original, SortingAlgorithms::insertionSort);
        timeAlgorithm("Merge Sort", original, SortingAlgorithms::mergeSort);
    }

    public static void timeAlgorithm(String name, int[] original, java.util.function.Consumer<int[]> sorter) {
        int[] copy = Arrays.copyOf(original, original.length);
        long start = System.nanoTime();
        sorter.accept(copy);
        long end = System.nanoTime();
        double timeMs = (end - start) / 1_000_000.0;
        System.out.printf("%-15s : %10.3f ms%n", name, timeMs);
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size);
        return arr;
    }

    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i;
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = size - i;
        return arr;
    }
}
