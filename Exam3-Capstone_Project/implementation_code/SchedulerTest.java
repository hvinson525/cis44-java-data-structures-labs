/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.schedulertest;

/**
 *
 * @author hvins
 */
public class SchedulerTest {

    public static void main(String[] args) {
        JobHeap scheduler = new JobHeap();
        
        scheduler.insert(new Job(1, 5, "Low priority job"));
        scheduler.insert(new Job(2, 10, "High priority job"));
        scheduler.insert(new Job(3, 7, "Medium priority job"));
        
        System.out.println("Next job to run: " + scheduler.peek());
        
        while (!scheduler.isEmpty()) {
            System.out.println("Running job: " + scheduler.extractMax());
        }
    }
}
