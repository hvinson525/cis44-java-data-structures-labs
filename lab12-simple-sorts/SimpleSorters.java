/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simplesortdriver;

/**
 *
 * @author hvins
 */
import java.util.Comparator;

public class SimpleSorters {


    public static <K> void bubbleSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (comp.compare(S[j], S[j + 1]) > 0) {
                    K temp = S[j];
                    S[j] = S[j + 1];
                    S[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }


    public static <K> void insertionSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        for (int i = 1; i < n; i++) {
            K cur = S[i];
            int j = i - 1;

            while (j >= 0 && comp.compare(S[j], cur) > 0) {
                S[j + 1] = S[j];
                j--;
            }

            S[j + 1] = cur;
        }
    }
}

