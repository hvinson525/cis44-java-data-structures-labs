/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fractaltree;

/**
 *
 * @author hvins
 */

import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {
    
    private final int MAX_DEPTH = 9;
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int startX = getWidth() / 2;
        int startY = getHeight() - 50;
        drawTree(g, startX, startY, -90, MAX_DEPTH);
    }
    
    /**
     * Recursively draws a fractal tree.
     * @param g The graphics object to draw on.
     * @param x1 The starting x-coordinate of the branch.
     * @param y1 The starting y-coordinate of the branch.
     * @param angle The angle of the branch in degrees.
     * @param depth The current recursion depth.
     */
    
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        
        int branchLength = depth * 10;
        
        double rad = Math.toRadians(angle);
        int x2 = x1 + (int) (Math.cos(rad) * branchLength);
        int y2 = y1 + (int) (Math.sin(rad) * branchLength);
        
        g.setColor(new Color(0, 100 + depth * 15, 0));
        
        g.drawLine(x1, y1, x2, y2);
        
        drawTree(g, x2, y2, angle - 20, depth - 1);
        drawTree(g, x2, y2, angle + 20, depth - 1);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.add(new FractalTree());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
