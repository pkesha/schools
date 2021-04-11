package com.ga.contentbackend.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.List;


//Entity is each object an entry in the
//table-> which is denoted with @Table
@Entity
@Table(name = "categories")
public class Category {

    //Indicates a PK
    @Id
    @Column
    //Makes it unique in a serial fashion.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @OneToMany(mappedBy="category")
    private List<Review> reviewList;


    public Category(Long id, String title, String description,
                    List<Review> reviewList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.reviewList = reviewList;
    }

    //Default case
    public Category() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
