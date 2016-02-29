package com.cny0166.assignmentone;

import java.util.Scanner;

/**
 * Created by Julian on 5/08/2015.
 */
public class CinemaTicketBookingApplication {

    private static Scanner keyboard = new Scanner(System.in);

    public static Film film1 = new Film("Ant-Man", 'P');
    public static Film film2 = new Film("Minions", 'P');
    public static Film film3 = new Film("Jurassic World", 'M');
    public static Film film4 = new Film("Inside Out", 'G');
    public static Film[] filmsList = {film1, film2, film3, film4};
    private static final int NUMBER_OF_FILMS = filmsList.length;

    public static void main(String[] args) {

        boolean cont = true; //Cont boolean decides whether another ticket should be issued.

        while (cont) { //Collects customer and film information, and generates applicable objects.
            Customer customer = customerDetailsInput();
            Film chosenFilm = filmSelection();

            while (chosenFilm == null) { //Makes sure a valid film was selcted. If it wasn't, null is returned, and it asks for the film again.
                chosenFilm = filmSelection();
            }

            Ticket ticket = issueTicket(customer, chosenFilm); //If an age appropriate movie was selected, print the movie, otherwise display an error.
            if (ticket != null) {
                System.out.println(ticket.toString());
            } else {
                System.out.println("Sorry, cannot issue ticket for age restricted film");
            }

            System.out.println("Issue another ticket? (Y/N)"); //Ask if another ticket needs to be printed.
            keyboard.nextLine();
            String response = keyboard.nextLine();
            if (response.equalsIgnoreCase("n")) cont = false;
        }

    }

    private static Customer customerDetailsInput() { //Collect customer information using Scanner and return the information as a Customer object.
        System.out.println("Please enter your name:"); //Collects name information
        String name = keyboard.nextLine();

        System.out.println("Please enter your age:"); //Collects age information
        int age = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("Are you a student? (Y/N):"); //Checks if the customer is a student.
        boolean student =  false;
        char studentChar = keyboard.next().charAt(0);
        if (studentChar == 'y' || studentChar == 'Y') {
            student = true;
        } else if (studentChar == 't' || studentChar == 'T') {
            student = false;
        }

        return new Customer(name, age, student); //Returns new Customer object.
    }

    private static Film filmSelection() { // Displays all films, and returns selected film object.
        for (int i = 0; i <= NUMBER_OF_FILMS - 1; i++) {
            System.out.println((i + 1) + ". " + filmsList[(i)]);
        }

        System.out.println();
        System.out.println("Which film would you like to see?:"); //Requests film selection

        int selection = keyboard.nextInt() - 1;
        if (selection < NUMBER_OF_FILMS && selection >= 0) return filmsList[(selection)]; //Check a valid film was selected

        else {
            System.out.println("Not a valid selection! Try again.");
            return null;
        }
    }

    public static Ticket issueTicket(Customer aCustomer, Film aFilm) { //Checks customer age with minimum movie age, using RATING enum. Returns ticket if age appropriate. Else null.

        int minAge = 18;

        if (aFilm.getRating() == 'G') {
            minAge = RATING.GENERAL.getMinAge();

        } else if (aFilm.getRating() == 'P') {
            minAge = RATING.PARENTAL_GUIDANCE.getMinAge();

        } else if (aFilm.getRating() == 'M') {
            minAge = RATING.MATURE.getMinAge();
        }

        if (aCustomer.getAge() >= minAge) {
            System.out.println("Your ticket is ready to be collected!");
            return new Ticket(aCustomer, aFilm);

        } else return null;

    }

}
