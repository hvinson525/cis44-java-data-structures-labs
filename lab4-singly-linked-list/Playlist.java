/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.playlistapp;

/**
 *
 * @author hvins
 */
public class Playlist {
    private static class Node {
        Song song;
        Node next;
        
        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }
    
    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;
    
    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }
    
    public void addSong(Song song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println(song + " added to playlist.");
    }
    
    public void removeSong(String title) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        
        if (head.song.getTitle().equalsIgnoreCase(title)) {
            System.out.println("Removing: " + head.song);
            if (head == tail) {
                head = tail = currentNode = null;
            } else {
                if (currentNode == head) {
                    currentNode = head.next;
                }
                head = head.next;
            }
            size--;
            return;
        }
        
        Node prev = head;
        Node curr = head.next;
        
        while (curr != null) {
            if (curr.song.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Removing: " + curr.song);
                prev.next = curr.next;
                if (curr == tail) {
                    tail = prev;
                }
                if (curr == currentNode) {
                    currentNode = curr.next != null ? curr.next : head;
                }
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        
        System.out.println("Song titled \"" + title + "\" not found.");
    }
    
    public void playNext() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        
        if (currentNode == null || currentNode.next == null) {
            currentNode = head;
        } else {
            currentNode = currentNode.next;
        }
        
        System.out.println("Now playing: " + currentNode.song);
    }
    
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty");
            return;
        }
        
        System.out.println("\n--- Playlist ---");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.song);
            temp = temp.next;
        }
        System.out.println("-----------------\n");
    }
}
