/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.playlistapp;

/**
 *
 * @author hvins
 */
import java.util.Scanner;

public class PlaylistApp {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("=== Music Playlist Menu ===");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Next Song");
            System.out.println("4. Display Playlist");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }
            
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    playlist.addSong(new Song(title, artist));
                    break;

                case 2:
                    System.out.print("Enter the title of the song to remove: ");
                    String removeTitle = scanner.nextLine();
                    playlist.removeSong(removeTitle);
                    break;

                case 3:
                    playlist.playNext();
                    break;

                case 4:
                    playlist.displayPlaylist();
                    break;

                case 5:
                    System.out.println("Exiting. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 5);
        
        scanner.close();
    }
}
