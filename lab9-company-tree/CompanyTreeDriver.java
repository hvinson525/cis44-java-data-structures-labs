/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.companytreedriver;

/**
 *
 * @author hvins
 */
public class CompanyTreeDriver {
    public static void main(String[] args) {
        GeneralTreeNode root = new GeneralTreeNode("CEO ");
        
        GeneralTreeNode vpSales = new GeneralTreeNode("VP of Sales ");
        GeneralTreeNode vpEngineering = new GeneralTreeNode("VP of Engineering ");
        root.addChild(vpSales);
        root.addChild(vpEngineering);
        
        GeneralTreeNode salesNA = new GeneralTreeNode("Sales Manager (NA) ");
        GeneralTreeNode salesEU = new GeneralTreeNode("Sales Manager (EU) ");
        vpSales.addChild(salesNA);
        vpSales.addChild(salesEU);
        
        GeneralTreeNode devLead = new GeneralTreeNode("Dev Team Lead ");
        GeneralTreeNode qaLead = new GeneralTreeNode("QA Team Lead ");
        vpEngineering.addChild(devLead);
        vpEngineering.addChild(qaLead);
        
        GeneralTreeNode dev1 = new GeneralTreeNode("Developer 1 ");
        GeneralTreeNode dev2 = new GeneralTreeNode("Developer 2 ");
        devLead.addChild(dev1);
        devLead.addChild(dev2);
        
        System.out.println("--- Preorder Traversal (Company Hierarchy) ---");
        root.traversePreorder();
        
        System.out.println("\n--- Postorder Traversal (Staff Roll Call) ---");
        root.traversePostorder();
    }
}
