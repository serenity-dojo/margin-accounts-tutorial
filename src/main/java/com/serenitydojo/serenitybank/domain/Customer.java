package com.serenitydojo.serenitybank.domain;

import java.util.UUID;

public class Customer {

    private String id;
    private String firstName;
    private String lastName;

    private Customer(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Customer withName(String firstName, String lastName) {
        return new Customer(UUID.randomUUID().toString(), firstName, lastName);
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

