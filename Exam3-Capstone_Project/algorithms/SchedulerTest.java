/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.schedulertest;

/**
 *
 * @author hvins
 */
import java.util.Scanner;

/**
 * SchedulerTest.java
 * Interactive console program to demonstrate Phase 3 algorithms.
 */
public class SchedulerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JobHeap scheduler = new JobHeap();
        int jobId = 1;

        System.out.println("=== Job Scheduler Phase 3 Demo ===");
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a job");
            System.out.println("2. Show next job");
            System.out.println("3. Run all jobs");
            System.out.println("4. Update job priority");
            System.out.println("5. Remove a job");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter job description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter job priority: ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();
                    scheduler.insert(new Job(jobId++, priority, desc));
                    System.out.println("Job added!");
                    break;

                case 2:
                    Job nextJob = scheduler.peek();
                    System.out.println(nextJob != null ? "Next job: " + nextJob : "No jobs in system.");
                    break;

                case 3:
                    System.out.println("Running all jobs in priority order:");
                    while (!scheduler.isEmpty()) {
                        System.out.println("Executing: " + scheduler.extractMax());
                    }
                    break;

                case 4:
                    System.out.print("Enter job ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new priority: ");
                    int newPriority = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(scheduler.updatePriority(updateId, newPriority) ? "Priority updated!" : "Job ID not found.");
                    break;

                case 5:
                    System.out.print("Enter job ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(scheduler.removeJob(removeId) ? "Job removed!" : "Job ID not found.");
                    break;

                case 6:
                    System.out.println("Exiting Phase 3 demo.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}