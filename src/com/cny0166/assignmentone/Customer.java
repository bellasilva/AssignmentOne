package com.cny0166.assignmentone;

/**
 * Created by Julian on 5/08/2015.
 */
public class Customer {

    private String name;
    private int age;
    private boolean student;

    public Customer() {
        this("No Name", 0, false);
    } //Initialises default Customer object.

    public Customer(String name, int age, boolean student) { //Initialises Customer with parameters.
        this.name = name;
        this.age = age;
        this.student = student;
    }

    public String toString() { //String return for a Customer object.
        return "Name: " + this.name + ", Age: " + this.age + ", Student? " + this.student;
    }

    //Get methods are below.

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public boolean isStudent() {
        return student;
    }

}
