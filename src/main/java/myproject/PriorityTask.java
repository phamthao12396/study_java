package myproject;

import java.time.LocalDate;

public class PriorityTask extends ToDoList{
    private String priority;
    
    public PriorityTask(){}
    public PriorityTask(String name, String des, String status, LocalDate date, String priority) {
        this.name = name;
        this.description = des;
        this.status = status;
        this.dateCompletion = date;
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
