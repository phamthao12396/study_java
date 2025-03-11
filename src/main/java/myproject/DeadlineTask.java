package myproject;

import java.time.LocalDate;

public class DeadlineTask extends ToDoList{
    private LocalDate deadlineDate;

    public DeadlineTask(){}

    public DeadlineTask(String taskName, String des, String status, LocalDate completionDate, LocalDate deadlineDate){
        name= taskName;
        description = des;
        this.status =status;
        dateCompletion = completionDate;
        this.deadlineDate = deadlineDate;
    }

    public LocalDate getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(LocalDate deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

}
