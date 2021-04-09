package com.ga.contentbackend.model;

import java.time.LocalDate;

public class Comment {
    private Long id;
    private String text;
    private LocalDate date;

    public Comment(Long id, String text, LocalDate date) {
        this.id = id;
        this.text = text;
        this.date = date;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
