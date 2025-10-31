/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.companytreedriver;

/**
 *
 * @author hvins
 */
import java.util.ArrayList;
import java.util.List;


public class GeneralTreeNode {
    String name;
    GeneralTreeNode parent;
    List<GeneralTreeNode> children;
    
    public GeneralTreeNode(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }
    
    public void addChild(GeneralTreeNode child) {
        child.parent = this;
        this.children.add(child);
    }
    
    public void traversePreorder() {
        System.out.print(name);
        
        for (GeneralTreeNode child : children) {
            child.traversePreorder();
        }
    }
    
    public void traversePostorder() {
        for (GeneralTreeNode child : children) {
            child.traversePostorder();
        }
        
        System.out.println(name);
    }
}
