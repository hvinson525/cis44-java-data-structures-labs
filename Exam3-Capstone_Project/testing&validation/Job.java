/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maintestdriver;

/**
 *
 * @author hvins
 */
public class Job implements Comparable<Job> {
    private int id;
    private int priority;
    private String description;

    public Job(int id, int priority, String description) {
        this.id = id;
        this.priority = priority;
        this.description = description;
    }

    public int getId() { return id; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
    public String getDescription() { return description; }

    @Override
    public int compareTo(Job other) {
        // Max-Heap: higher priority number comes first
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Job[ID=" + id + ", Priority=" + priority + ", Desc=" + description + "]";
    }
}

