/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.avltreedriver;

/**
 *
 * @author hvins
 */
public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(5);
        tree.insert(4); 
        tree.insert(8);  
        tree.insert(25); 

        System.out.print("Inorder: ");
        tree.inorder();

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();
    }
}
