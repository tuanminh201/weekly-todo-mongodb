package com.minh.weekly_todo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")
public class TodoItem {
    @Id
    private String id;
    private String title;
    private String description;
    private String day; // e.g., "Monday", "Tuesday"
    private boolean completed;

    public TodoItem() {}

    public TodoItem(String title, String description, String day, boolean completed) {
        this.title = title;
        this.description = description;
        this.day = day;
        this.completed = completed;
    }

    public String getId() {
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
