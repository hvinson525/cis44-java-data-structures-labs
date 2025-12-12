/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maintestdriver;

/**
 *
 * @author hvins
 */
import java.util.ArrayList;

/**
 * JobHeap.java
 * Implements a heap-based priority queue for jobs.
 */
public class JobHeap {
    private ArrayList<Job> heap;

    public JobHeap() {
        heap = new ArrayList<>();
    }

    // Insert a new job
    public void insert(Job job) {
        heap.add(job);
        upHeap(heap.size() - 1);
    }

    // Remove and return the highest priority job
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

    // Peek at the highest priority job without removing
    public Job peek() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    // Update the priority of a specific job
    public boolean updatePriority(int jobId, int newPriority) {
        int index = findIndexById(jobId);
        if (index == -1) return false;

        int oldPriority = heap.get(index).getPriority();
        heap.get(index).setPriority(newPriority);

        if (newPriority > oldPriority) {
            upHeap(index);
        } else {
            downHeap(index);
        }
        return true;
    }

    // Remove a job by its ID
    public boolean removeJob(int jobId) {
        int index = findIndexById(jobId);
        if (index == -1) return false;

        Job last = heap.remove(heap.size() - 1);
        if (index < heap.size()) {
            heap.set(index, last);
            upHeap(index);
            downHeap(index);
        }
        return true;
    }

    public boolean isEmpty() { return heap.isEmpty(); }
    public int size() { return heap.size(); }

    // --- Private helper methods ---
    private int findIndexById(int jobId) {
        for (int i = 0; i < heap.size(); i++) {
            if (heap.get(i).getId() == jobId) return i;
        }
        return -1;
    }

    private void upHeap(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) <= 0) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void downHeap(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size && heap.get(left).compareTo(heap.get(largest)) > 0) largest = left;
            if (right < size && heap.get(right).compareTo(heap.get(largest)) > 0) largest = right;

            if (largest == index) break;
            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int i, int j) {
        Job temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

