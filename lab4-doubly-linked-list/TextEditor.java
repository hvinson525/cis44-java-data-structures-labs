/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.texteditorapp;

/**
 *
 * @author hvins
 */
public class TextEditor {
    private static class Node {
        String textState;
        Node prev;
        Node next;
        
        Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private Node currentNode;
    
    public TextEditor() {
        currentNode = new Node("", null, null);
    }
    
    public void add(String newText) {
        currentNode.next = null;
        
        String updatedText = currentNode.textState + newText;
        
        Node newNode = new Node(updatedText, currentNode, null);
        currentNode.next = newNode;
        currentNode = newNode;
        
        System.out.println("Text added.");
    }
    
    public String undo() {
        if (currentNode.prev != null) {
            currentNode = currentNode.prev;
            return currentNode.textState;
        } else {
            System.out.println("Cannot undo further.");
            return currentNode.textState;
        }
    }
    
    public String redo() {
        if (currentNode.next != null) {
            currentNode = currentNode.next;
            return currentNode.textState;
        } else {
            System.out.println("Cannot redo further.");
            return currentNode.textState;
        }
    }
    
    public void printCurrent() {
        System.out.println("\n--- Current Text State ---");
        System.out.println(currentNode.textState);
        System.out.println("--------------------------\n");
    }
}
