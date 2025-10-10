/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.syntaxchecker;

/**
 *
 * @author hvins
 */
public class ArrayStack<T> implements Stack<T> {
    private T[] data;
    private int top;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (T[]) new Object[capacity];
        top = 0;
    }

    @Override
    public void push(T item) {
        if (top == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[top++] = item;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = data[--top];
        data[top] = null; 
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }
}

