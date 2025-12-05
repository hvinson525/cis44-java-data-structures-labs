/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schedulertest;

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
    
    public int getID() {
        return id;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public String getDescription() {
        return description;
    }
    
    @Override
    public int compareTo(Job other) {
        // Max-Heap: Higher priority value comes first
        return Integer.compare(other.priority, this.priority);
    }
    
    @Override
    public String toString() {
        return "Job[ID=" + id + ", Priority=" + priority + ", Desc=" + description + "]";
    }
}
