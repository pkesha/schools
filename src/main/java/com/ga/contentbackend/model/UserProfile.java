package com.ga.contentbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @Column
    //Makes it unique in a serial fashion.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @JsonIgnore
    @OneToOne(mappedBy="userProfile")
    private User user;


//    @Column
//    private List<String> credentials;

    public UserProfile(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.credentials = credentials;
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

    /**User One to One binding**/
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//
//    public List<String> getCredentials() {
//        return credentials;
//    }
//
//    public void setCredentials(List<String> credentials) {
//        this.credentials = credentials;
//    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
