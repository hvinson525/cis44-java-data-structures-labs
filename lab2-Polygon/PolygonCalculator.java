/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.polygoncalculator;

/**
 *
 * @author hvins
 */
import java.util.Scanner;

interface Polygon {
    double area();
    double perimeter();
}        


class Quadrilateral implements Polygon {
    protected double side1, side2, side3, side4;
    
    public Quadrilateral(double side1, double side2, double side3, double side4) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
    }
    
    @Override
    public double area() {
        return 0;
    }
    
    @Override
    public double perimeter() {
        return side1 + side2 + side3 + side4;
    }
}

class Rectangle extends Quadrilateral {
    protected double length;
    protected double width;
    
    public Rectangle(double length, double width) {
        super(length, width, length, width);
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double area() {
        return length * width;
    }
    
    @Override
    public double perimeter() {
        return 2 * (length+width);
    }
}

class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

class Triangle implements Polygon {
    protected double a, b, c;
    
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public double perimeter() {
        return a + b + c;
    }
    
    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * ( s - c));
    }
}

class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double equalSide, double base) {
        super(equalSide, equalSide, base);
    }
}

class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(double side) {
        super(side, side, side);
    }
    
    @Override
    public double area() {
        return (Math.sqrt(3) / 4) * a * a;
    }
}

class Pentagon implements Polygon {
    private final double side;
    
    public Pentagon(double side) {
        this.side = side;
    }
    
    @Override
    public double perimeter() {
        return 5 * side;
    }
    
    @Override
    public double area() {
        return (5 * side * side) / (4 * Math.tan(Math.PI / 5));
    }
}

class Hexagon implements Polygon {
    private final double side;
    
    public Hexagon(double side) {
        this.side = side;
    }
    
    @Override
    public double perimeter() {    
        return 6 * side;
    }
    
    @Override
    public double area() {
        return ((3 * Math.sqrt(3)) / 2) * side * side;
    }
}

class Octagon implements Polygon {
    private final double side;

    public Octagon(double side) {
        this.side = side;
    }
    
    @Override
    public double perimeter() {
        return 8 * side;
    }
    
    @Override
    public double area() {
        return 2 * (1 + Math.sqrt(2)) * side * side;
    }
}

public class PolygonCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Polygon polygon = null;
        
        System.out.println("Create a polygon:");
        System.out.println("1. Triangle");
        System.out.println("2. Isosceles Triangle");
        System.out.println("3. Equilateral Triangle");
        System.out.println("4. Quadrilateral");
        System.out.println("5. Rectangle");
        System.out.println("6. Square");
        System.out.println("7. Pentagon");
        System.out.println("8. Hexagon");
        System.out.println("9. Octagon");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                System.out.print("Enter side 1: ");
                double t1 = scanner.nextDouble();
                System.out.print("Enter side 2: ");
                double t2 = scanner.nextDouble();
                System.out.print("Enter side 3: ");
                double t3 = scanner.nextDouble();
                polygon = new Triangle(t1, t2, t3);
                break;
            case 2:
                System.out.print("Enter the equal side: ");
                double eqSide = scanner.nextDouble();
                System.out.print("Enter the base: ");
                double base = scanner.nextDouble();
                polygon = new IsoscelesTriangle(eqSide, base);
                break;
            case 3:
                System.out.print("Enter the side: ");
                double side = scanner.nextDouble();
                polygon = new EquilateralTriangle(side);
                break;
            case 4:
                System.out.print("Enter side 1: ");
                double q1 = scanner.nextDouble();
                System.out.print("Enter side 2: ");
                double q2 = scanner.nextDouble();
                System.out.print("Enter side 3: ");
                double q3 = scanner.nextDouble();
                System.out.print("Enter side 4: ");
                double q4 = scanner.nextDouble();
                polygon = new Quadrilateral(q1, q2, q3, q4);
                break;
            case 5:
                System.out.print("Enter the length: ");
                double length = scanner.nextDouble();
                System.out.print("Enter the width: ");
                double width = scanner.nextDouble();
                polygon = new Rectangle(length, width);
                break;
            case 6:
                System.out.print("Enter the side: ");
                double s = scanner.nextDouble();
                polygon = new Square(s);
                break;
            case 7:
                System.out.print("Enter the side: ");
                double pSide = scanner.nextDouble();
                polygon = new Pentagon(pSide);
                break;
            case 8:
                System.out.print("Enter the side: ");
                double hSide = scanner.nextDouble();
                polygon = new Hexagon(hSide);
                break;
            case 9:
                System.out.print("Enter the side: ");
                double oSide = scanner.nextDouble();
                polygon = new Octagon(oSide);
                break;
         default:
                System.out.println("Invalid choice.");
                return;                
            }
        
        System.out.printf("Perimeter: %.2f\n", polygon.perimeter());
        System.out.printf("Area: %.2f\n", polygon.area());
    }
}

