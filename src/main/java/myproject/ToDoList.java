package myproject;

import java.time.LocalDate;

public class ToDoList {
    private String name;
    private String description;
    private String status;
    private LocalDate dateCompletion;

    public ToDoList(){}

    public ToDoList(String name, String description, String status, LocalDate completionDate){
        this.name = name;
        this.description = description;
        this.status = status;
        this.dateCompletion = completionDate;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDate getDateCompletion() {
        return dateCompletion;
    }
    public void setDateCompletion(LocalDate dateCompletion) {
        this.dateCompletion = dateCompletion;
    }
}
