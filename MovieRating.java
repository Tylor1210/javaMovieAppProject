package movieRating;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieRating {
    private static List<String> movies = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Basic program flow:
        // - Display menu in a loop
        // - User selects option
        // - Call corresponding function
        // - Repeat until exit
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addMovie();
                    break;
                case "2":
                    listMovies();
                    break;
                case "3":
                    listMovies();
                    break;
                case "4":
                	deleteMovies();
                	break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Movie List Manager ===");
        System.out.println("1. Add a movie");
        System.out.println("2. View movie list");
        System.out.println("3. Delete");
        System.out.println("4. Exit");
        System.out.print("Choose an option (1-3): ");
    }

    private static void addMovie() {
        // Get input from user and store in an ArrayList
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        if (!title.isEmpty()) {
            movies.add(title);
            System.out.println(title + " added to the list!");
        } else {
            System.out.println("Invalid title. Try again.");
        }
    }

    private static void listMovies() {
        // Display movies from an ArrayList
        if (movies.isEmpty()) {
            System.out.println("\nNo movies in the list yet.");
            return;
        }
        System.out.println("\n=== Movie List ===");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i));
        }
    }
    
    private static void deleteMovies() {
        if (movies.isEmpty()) {
            System.out.println("\nNo movies in the list yet.");
            return;
        }

        listMovies(); // Show the current list with indices
        System.out.print("Enter the movie title to remove: ");
        String movieToRemove = scanner.nextLine();

        boolean removed = false;
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).equalsIgnoreCase(movieToRemove)) {
                String removedMovie = movies.remove(i);
                System.out.println("Removed: " + removedMovie);
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Movie not found in the list.");
        }

        if (!movies.isEmpty()) {
            System.out.println("Updated list: " + movies);
        } else {
            System.out.println("The movie list is now empty.");
        }
    }
    
    
}