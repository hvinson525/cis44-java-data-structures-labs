/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author hvins
 */
public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        
        inventory.addItem(new Item("Wood"));
        inventory.addItem(new Item("Stone"));
        inventory.addItem(new Item("Iron"));
        inventory.addItem(new Item("Magic Crystal"));
        
        System.out.println("Initial Inventory:");
        inventory.display();
        
        inventory.combineItems("Wood", "Magic Crystal");
        
        System.out.println("Inventory After Combination");
        inventory.display();
        
        inventory.combineItems("Wood", "Diamond");
        
        System.out.println("Final Inveotry:");
        inventory.display();
    }
}
