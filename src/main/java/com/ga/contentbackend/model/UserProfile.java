package com.ga.contentbackend.model;

import java.util.List;

public class UserProfile {

    private Long id;
    private String firstName;
    private String lastName;
    private List<String> credentials;

    public UserProfile(Long id, String firstName, String lastName, List<String> credentials) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentials = credentials;
    }

    public UserProfile() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<String> credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
