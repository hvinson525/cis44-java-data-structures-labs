/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.separatechainingmapdriver;

/**
 *
 * @author hvins
 */
import java.util.ArrayList;
import java.util.LinkedList;

// --- MapADT Interface ---
interface MapADT<K, V> {
    V put(K key, V value);
    V get(K key);
    V remove(K key);
    int size();
    boolean isEmpty();
}

// --- Separate Chaining Hash Map ---
public class SeparateChainingMap<K, V> implements MapADT<K, V> {
    private ArrayList<LinkedList<Entry<K, V>>> table;
    private int size = 0;
    private final int N = 11; // prime number for table capacity

    // --- Entry class ---
    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }

    // --- Constructor ---
    public SeparateChainingMap() {
        table = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            table.add(new LinkedList<Entry<K, V>>());
        }
    }

    // --- Hash function ---
    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % N);
    }

    // --- MapADT methods ---
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public V get(K key) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        for (Entry<K, V> entry : bucket) {
            if ((key == null && entry.getKey() == null) || 
                (key != null && key.equals(entry.getKey()))) {
                return entry.getValue();
            }
        }
        return null;
    }

    public V put(K key, V value) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        for (Entry<K, V> entry : bucket) {
            if ((key == null && entry.getKey() == null) ||
                (key != null && key.equals(entry.getKey()))) {
                return entry.setValue(value);
            }
        }

        bucket.addFirst(new Entry<>(key, value));
        size++;
        return null;
    }

    public V remove(K key) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : bucket) {
            if ((key == null && entry.getKey() == null) || 
                (key != null && key.equals(entry.getKey()))) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            V oldValue = toRemove.getValue();
            bucket.remove(toRemove);
            size--;
            return oldValue;
        }

        return null;
    }
}

