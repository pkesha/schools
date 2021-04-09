package com.ga.contentbackend.model;

import java.time.LocalDate;

public class Review {
    private Long id;
    private String title;
    private String text;
    private LocalDate date;

    public Review(Long id, String title, String text, LocalDate date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public Review() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
