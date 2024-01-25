package com.masterspringspringboot.myfirstwebapp.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table
public class ToDo {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    @Size(min=5,message="Enter at least 5 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;

    public ToDo(int id, String username, String description, LocalDate targetDate, boolean done) {
        super();
        this.id= id;
        this.username= username;
        this.description= description;
        this.targetDate= targetDate;
        this.done= done;
    }

    public ToDo(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }

}
