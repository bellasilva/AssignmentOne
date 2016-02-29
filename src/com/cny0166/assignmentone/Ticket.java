package com.cny0166.assignmentone;

/**
 * Created by Julian on 5/08/2015.
 */

public class Ticket {

    Film film = new Film();
    Customer customer = new Customer();
    float cost;
    int discount = 0;

    public Ticket(Customer customer, Film film) { //Ticket constructor with parameters.

        this.film = film;
        this.customer = customer;
        this.cost = cost();

    }

    public Customer getCustomer() {
        return customer;
    }

    public Film getFilm() {
        return film;
    }

    public double getCost() {
        return this.cost;
    }

    public float cost() { //Figures out cost of ticket taking discounts in to account.
        //Variable discount is the % discount as an integer so it is easy to change for other devs.

        if (customer.getAge() >= 18) {
            cost = 10;
        } else {
            cost = 7;
        }

        if (customer.isStudent() && customer.getAge() >= 10  && customer.getAge() <= 25) {
            discount = 15;
        } else if (customer.isStudent() && customer.getAge() > 25) {
            discount = 10;
        } else if (customer.getAge() >= 65) {
            discount = 7;
        }

        return cost * (1 - ((float) discount / 100)); //Converts discount int to a float, and works out final cost by simple multiplcation. Returns the cost.

    }

    public String toString() { //Ticket string for printing.
        String ticketPrint = ("------------------------------------------------------------\n" +
                "FILM TICKET for: " + film + "\n" + "CUSTOMER DETAILS: " + customer + "\n" + "TOTAL COST $" + String.format("%.2f", cost) +
                "\n------------------------------------------------------------");
            return ticketPrint;
    }

}
