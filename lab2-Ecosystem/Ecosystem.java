/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ecosystem;

/**
 *
 * @author hvins
 */
import java.util.Random;
import java.util.Scanner;

abstract class Animal {
    public abstract String toString();
}

class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }
}

public class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();
        populateRiver();
    }

    private void populateRiver() {
        for (int i = 0; i < river.length; i++) {
            int roll = random.nextInt(4);
            if (roll == 0) {
                river[i] = new Bear();
            } else if (roll == 1) {
                river[i] = new Fish();
            } else {
                river[i] = null;
            }
        }
    }

    public void runStep() {
        Animal[] nextRiver = new Animal[river.length];
        boolean[] moved = new boolean[river.length];

        for (int i = 0; i < river.length; i++) {
            if (river[i] != null && !moved[i]) {
                int move = random.nextInt(3) - 1;
                int target = i + move;

                if (target < 0 || target >= river.length || move == 0) {
                    if (nextRiver[i] == null)
                        nextRiver[i] = river[i];
                } else if (nextRiver[target] == null) {
                    if (river[target] == null || moved[target]) {
                        nextRiver[target] = river[i];
                        moved[target] = true;
                    } else {
                        Animal other = river[target];
                        if (river[i].getClass() == other.getClass()) {
                            nextRiver[target] = river[i];
                            birthNewAnimal(river[i].getClass(), nextRiver);
                        } else if (river[i] instanceof Bear && other instanceof Fish) {
                            nextRiver[target] = river[i]; 
                        } else if (river[i] instanceof Fish && other instanceof Bear) {
                            nextRiver[target] = other; 
                        }
                        moved[target] = true;
                    }
                } else {
                    if (nextRiver[i] == null)
                        nextRiver[i] = river[i];
                }
            }
        }

        river = nextRiver;
    }

    private void birthNewAnimal(Class<?> type, Animal[] nextRiver) {
        int[] emptyCells = java.util.stream.IntStream.range(0, nextRiver.length)
                .filter(i -> nextRiver[i] == null)
                .toArray();

        if (emptyCells.length == 0)
            return;

        int randomIndex = emptyCells[random.nextInt(emptyCells.length)];

        if (type == Bear.class) {
            nextRiver[randomIndex] = new Bear();
        } else if (type == Fish.class) {
            nextRiver[randomIndex] = new Fish();
        }
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystem eco = new Ecosystem(20); 
        Scanner scanner = new Scanner(System.in);

        eco.visualize();

        for (int step = 0; step < 50; step++) {
            System.out.print("Press Enter to run step " + (step + 1));
            scanner.nextLine();
            eco.runStep();
            eco.visualize();
        }

        scanner.close();
    }
}
