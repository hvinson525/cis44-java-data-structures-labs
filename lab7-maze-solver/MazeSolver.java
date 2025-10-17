/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mazesolver;

/**
 *
 * @author hvins
 */
public class MazeSolver {
    
    private char[][] maze;
    
    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }
    
    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }
    
    public boolean solve() {
        int startRow = -1;
        int startCol = -1;
        
        for(int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }
        
        if (startRow != -1) {
            return solve(startRow, startCol);
        }
        return false;
    }
    
    private boolean solve(int row, int col) {
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) {
            return false;
        }
        
        if (maze[row][col] == '#' || maze[row][col] == '.') {
            return false;
        }
        
        if (maze[row][col] == 'F') {
            return true;
        }
        
        if (maze[row][col] != 'S') {
            maze[row][col] = '.';
        }
        
        if (solve(row - 1, col)) return true;
        if (solve(row, col + 1)) return true;
        if (solve(row + 1, col)) return true;
        if (solve(row, col - 1)) return true;
        
        if (maze[row][col] != 'S') {
            maze[row][col] = '.';
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        char[][] mazeToSolve = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', 'F', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
        };
        
        MazeSolver solver = new MazeSolver(mazeToSolve);
        
        System.out.println("Original Maze:");
        solver.printMaze();
        
        if (solver.solve()) {
            System.out.println("✅ Solution Found:");
        } else {
            System.out.println("❌ No Solution Found:");
        }

        solver.printMaze();

        // Maze with no solution
        char[][] blockedMaze = {
            {'#', '#', '#', '#', '#'},
            {'#', 'S', ' ', '#', '#'},
            {'#', ' ', '#', ' ', '#'},
            {'#', '#', '#', 'F', '#'},
            {'#', '#', '#', '#', '#'}
        };

        MazeSolver solver2 = new MazeSolver(blockedMaze);

        System.out.println("Blocked Maze:");
        solver2.printMaze();

        if (solver2.solve()) {
            System.out.println("✅ Solution Found:");
        } else {
            System.out.println("❌ No Solution Found:");
        }

        solver2.printMaze();
    }
}
