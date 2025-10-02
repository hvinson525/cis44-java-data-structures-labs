/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author hvins
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Item> items;
    
    public Inventory() {
        this.items = new ArrayList<>();
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public void display() {
        System.out.println("Inventory");
        if (items.isEmpty()) {
            System.out.println("  (empty)");
        } else {
            for (Item item : items) {
                System.out.println("  - " + item);
            }
        }
        System.out.println();
    }
    
    public void combineItems(String name1, String name2) {
    Item firstItem = null;
    Item secondItem = null;

    Iterator<Item> iter = items.iterator();

    List<Item> matchedItems = new ArrayList<>();

    // Collect matches first
    while (iter.hasNext()) {
        Item current = iter.next();
        if (current.getName().equals(name1) || current.getName().equals(name2)) {
            matchedItems.add(current);
        }
    }

    // Handle same-name case (e.g., Wood + Wood)
    if (name1.equals(name2)) {
        int count = 0;
        for (Item item : matchedItems) {
            if (item.getName().equals(name1)) count++;
        }

        if (count < 2) {
            System.out.println("Not enough items to combine \"" + name1 + "\" twice.\n");
            return;
        }

        // Get first two matching items
        int found = 0;
        for (Item item : items) {
            if (item.getName().equals(name1)) {
                if (found == 0) firstItem = item;
                else if (found == 1) {
                    secondItem = item;
                    break;
                }
                found++;
            }
        }
    } else {
        // Different item names
        for (Item item : matchedItems) {
            if (firstItem == null && item.getName().equals(name1)) {
                firstItem = item;
            } else if (secondItem == null && item.getName().equals(name2)) {
                secondItem = item;
            }
        }
    }

    // Remove items only if both were found
    if (firstItem != null && secondItem != null) {
        // Remove both items safely using iterator
        iter = items.iterator();
        while (iter.hasNext()) {
            Item current = iter.next();
            if (current == firstItem || current == secondItem) {
                iter.remove();
            }
        }

        // Add combined item
        String combinedName = name1 + "-" + name2 + " Combo Item";
        Item combinedItem = new Item(combinedName);
        items.add(combinedItem);

        System.out.println("Combined \"" + name1 + "\" and \"" + name2 + "\" into \"" + combinedName + "\".\n");
    } else {
        System.out.println("Could not find both items to combine.\n");
    }
  }
}
