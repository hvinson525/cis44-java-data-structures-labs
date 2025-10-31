/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.expressiontreedriver;

/**
 *
 * @author hvins
 */
public class BinaryTreeNode {
    String value;
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(String value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public void traversePreorder() {
        System.out.print(value + " ");

        if (left != null) {
            left.traversePreorder();
        }

        if (right != null) {
            right.traversePreorder();
        }
    }

    public void traverseInorder() {
        if (left != null) {
            System.out.print("(");
            left.traverseInorder();
        }

        System.out.print(value);

        if (right != null) {
            right.traverseInorder();
            System.out.print(")");
        }
    }

    public void traversePostorder() {
        if (left != null) {
            left.traversePostorder();
        }

        if (right != null) {
            right.traversePostorder();
        }

        System.out.print(value + " ");
    }
}

