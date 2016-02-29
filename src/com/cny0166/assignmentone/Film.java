package com.cny0166.assignmentone;

/**
 * Created by Julian on 5/08/2015.
 */

public class Film {

    private String title;
    private char rating;

    public Film() { //Empty film constructor - assigns default values.
        this.title = "No Title Set";
        this.rating = '-';
    }

    public Film(String title, char rating) { //Film constructor
        this.title = title;
        this.rating = rating;

    }

    public String getTitle() {
        return title;
    }

    public char getRating() {
        return rating;
    }

    public String toString() {
        return this.title + " rating: (" + this.getRating() + ")";
    }

}
