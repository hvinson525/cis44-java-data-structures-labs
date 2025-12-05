/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schedulertest;

/**
 *
 * @author hvins
 */
import java.util.ArrayList;

public class JobHeap {
    private ArrayList<Job> heap;
    
    public JobHeap() {
        heap = new ArrayList<>();
    }
    
    public void insert(Job job) {
        heap.add(job);
        upHeap(heap.size() - 1);
    }
    
    public Job extractMax() {
        if (heap.isEmpty()) return null;
        Job root = heap.get(0);
        Job last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            downHeap(0);
        }
        return root;
    }
    
    public Job peek() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }
    
    private void upHeap(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) <= 0) break;
            swap(index, parent);
            index = parent;
        }
    }
    
    public void downHeap(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;
            
            if (left < size && heap.get(left).compareTo(heap.get(largest)) > 0) {
                largest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(largest)) > 0) {
                largest = right;
            }
            if (largest == index) break;
            swap(index, largest);
            index = largest;
        }
    }
    
    public void swap(int i, int j) {
        Job temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    public int size() {
        return heap.size();
    }
}