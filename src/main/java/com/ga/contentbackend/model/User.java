package com.ga.contentbackend.model;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column
    //Makes it unique in a serial fashion.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Makes sure every emailAddress entry in the column is unique
    @Column(unique = true)
    private String emailAddress;

    @Column
    private String password;

    @OneToOne
    @JoinColumn(name = "user_profile_id", referencedColumnName = "id")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user")
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private List<Category> categoryList;

    @OneToMany(mappedBy = "user")
    private List<Review> reviewList;

    @OneToMany(mappedBy = "user")
    private List<Comment> commentList;

    public User(Long id, String emailAddress, String password) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * User Profile one ot one binding
     */
    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
