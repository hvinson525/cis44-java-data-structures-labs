/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maintestdriver;

/**
 *
 * @author hvins
 */
public class MainTestDriver {
    public static void main(String[] args) {

        System.out.println("=== Phase 4: Manual PASS/FAIL Tests ===");

        // ----- Test 1: Inserting and peeking highest priority -----
        JobHeap heap = new JobHeap();
        heap.insert(new Job(1, 5, "Task A"));
        heap.insert(new Job(2, 10, "Task B"));
        heap.insert(new Job(3, 1, "Task C"));

        Job peekResult = heap.peek();
        if (peekResult != null && peekResult.getPriority() == 10) {
            System.out.println("Test 1 (Peek highest priority) .... PASS");
        } else {
            System.out.println("Test 1 (Peek highest priority) .... FAIL");
        }

        // ----- Test 2: Extracting max -----
        Job extract = heap.extractMax();
        if (extract != null && extract.getPriority() == 10) {
            System.out.println("Test 2 (ExtractMax returns highest) PASS");
        } else {
            System.out.println("Test 2 (ExtractMax returns highest) FAIL");
        }

        // ----- Test 3: Empty heap behavior -----
        JobHeap emptyHeap = new JobHeap();
        if (emptyHeap.peek() == null) {
            System.out.println("Test 3 (Peek on empty heap) .... PASS");
        } else {
            System.out.println("Test 3 (Peek on empty heap) .... FAIL");
        }

        // ----- Test 4: Updating a job’s priority -----
        JobHeap updateTest = new JobHeap();
        updateTest.insert(new Job(1, 2, "Low job"));
        updateTest.insert(new Job(2, 8, "High job"));

        updateTest.updatePriority(1, 20);  // Now job 1 should be highest

        if (updateTest.peek().getId() == 1) {
            System.out.println("Test 4 (Update priority) .... PASS");
        } else {
            System.out.println("Test 4 (Update priority) .... FAIL");
        }

        // ----- Test 5: Removing a job -----
        JobHeap removeTest = new JobHeap();
        removeTest.insert(new Job(1, 5, "Job"));
        boolean removed = removeTest.removeJob(1);

        if (removed && removeTest.isEmpty()) {
            System.out.println("Test 5 (Remove a job) .... PASS");
        } else {
            System.out.println("Test 5 (Remove a job) .... FAIL");
        }

        System.out.println("\n=== End of Phase 4 Manual Tests ===");
    }
}

