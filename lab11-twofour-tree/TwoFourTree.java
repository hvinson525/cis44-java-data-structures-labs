/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.twofourtreedriver;

/**
 *
 * @author hvins
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean isFull() {
        return keys.size() == 3;
    }

    public TwoFourNode getNextChild(int key) {
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    public void insertKey(int key) {
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        node.insertKey(key);

        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent;
        }
    }

    private void split(TwoFourNode node) {
        System.out.println("Splitting node with keys: " + node.keys);

        int midKey = node.keys.get(1);

        TwoFourNode left = new TwoFourNode();
        TwoFourNode right = new TwoFourNode();

        left.keys.add(node.keys.get(0));
        right.keys.add(node.keys.get(2));
        right.keys.add(node.keys.get(3));

        if (!node.isLeaf()) {
            left.children.add(node.children.get(0));
            left.children.add(node.children.get(1));
            right.children.add(node.children.get(2));
            right.children.add(node.children.get(3));
            right.children.add(node.children.get(4));

            for (TwoFourNode c : left.children) c.parent = left;
            for (TwoFourNode c : right.children) c.parent = right;
        }

        if (node.parent == null) {
            TwoFourNode newRoot = new TwoFourNode();
            newRoot.keys.add(midKey);

            newRoot.children.add(left);
            newRoot.children.add(right);

            left.parent = newRoot;
            right.parent = newRoot;

            root = newRoot;
            return;
        }

        TwoFourNode parent = node.parent;
        parent.insertKey(midKey);

        int childIndex = parent.children.indexOf(node);
        parent.children.remove(childIndex);

        parent.children.add(childIndex, right);
        parent.children.add(childIndex, left);

        left.parent = parent;
        right.parent = parent;
    }

    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) System.out.print(key + " ");
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                inorder(node.children.get(i));
                System.out.print(node.keys.get(i) + " ");
            }
            inorder(node.children.get(i));
        }
    }
}

