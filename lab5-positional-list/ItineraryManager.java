/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.itinerarymangaer;

/**
 *
 * @author hvins
 */
public class ItineraryManager {
    public static void main(String[] args) {
        LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();

        Position<String> p1 = itinerary.addLast("Eiffel Tower");
        Position<String> p2 = itinerary.addLast("Louvre Museum");
        Position<String> p3 = itinerary.addLast("Notre-Dame Cathedral");

        System.out.println("Initial Itinerary:");
        printItinerary(itinerary);

        itinerary.addAfter(p1, "Museum of Modern Art");

        itinerary.addBefore(p3, "Seine River Cruise");

        System.out.println("\nUpdated Itinerary:");
        printItinerary(itinerary);
    }

    public static void printItinerary(LinkedPositionalList<String> itinerary) {
        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }
    }
}
