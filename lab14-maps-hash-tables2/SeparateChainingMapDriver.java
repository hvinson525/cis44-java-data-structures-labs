/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.separatechainingmapdriver;

/**
 *
 * @author hvins
 */

public class SeparateChainingMapDriver {
    public static void main(String[] args) {

        SeparateChainingMap<String, String> map = new SeparateChainingMap<>();

        System.out.println("=== Collision Demonstration (N = 11) ===");

        // These keys are designed to collide in the hash table (same bucket)
        System.out.println("put(\"Aa\", \"Value1\"): " + map.put("Aa", "Value1"));   // null
        System.out.println("put(\"BB\", \"Value2\"): " + map.put("BB", "Value2"));   // null
        System.out.println("put(\"AaAa\", \"Value3\"): " + map.put("AaAa", "Value3"));// null

        // Retrieve all values
        System.out.println("\n=== Values in Map ===");
        System.out.println("get(\"Aa\"): " + map.get("Aa"));       // Value1
        System.out.println("get(\"BB\"): " + map.get("BB"));       // Value2
        System.out.println("get(\"AaAa\"): " + map.get("AaAa"));   // Value3

        // Remove one key
        System.out.println("\n=== Removing a key ===");
        System.out.println("remove(\"BB\"): " + map.remove("BB")); // Value2

        // Check size and remaining keys
        System.out.println("\n=== Map Status After Removal ===");
        System.out.println("size(): " + map.size());              // 2
        System.out.println("get(\"Aa\"): " + map.get("Aa"));       // Value1
        System.out.println("get(\"AaAa\"): " + map.get("AaAa"));   // Value3
        System.out.println("get(\"BB\"): " + map.get("BB"));       // null
    }
}



