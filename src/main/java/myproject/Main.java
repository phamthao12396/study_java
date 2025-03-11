package myproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<ToDoList> todoList = new ArrayList<>();

        //Add new "Task 1" to the todo list
        todoList.add(new ToDoList("Task 1", "do java exercise", "inprogress", null));
        todoList.add(new ToDoList("Task 2", "do java exercise", "inprogress", null));
        todoList.add(new ToDoList("Task 3", "do java exercise", "inprogress", null));
        //Remove a task from the list
        deleteTask(todoList);

        //Update the status of a task (pending/completed).
        updateStatus(todoList);

        //Display the task list.
        displayTaskList(todoList);

        //Search tasks by name or status.
        searchTaskList(todoList);
        
// App should able to add another tasks type in the future:
// + PriorityTask
//     Additional Attributes: priorityLevel (e.g., high, medium, low)
// + DeadlineTask
//     Additional Attribute: deadlineDate (a String or Date that stores the deadline of the task).
//gợi ý là áp dụng tính kế thừa với kế thừa của OOP cho phần mở rộng


        sc.close();
    }

    public static void deleteTask(ArrayList<ToDoList> todoList){
        System.out.println("Input Task name to delete: ");
        String taskName = sc.nextLine();
        for(int i=0; i< todoList.size(); i++){
            if (todoList.get(i).getName().equals(taskName)) {
                todoList.remove(i);
            }
        }
    }

    public static void updateStatus(ArrayList<ToDoList> todoLists){
        System.out.println("Input Task name to update: ");
        String taskName = sc.nextLine();
        System.out.println("1 = 'Pending', 2 = 'Completed'");
        System.out.println("Select status to update: ");
        int number = sc.nextInt();
        sc.nextLine();

        for (ToDoList item : todoLists) {
            if (item.getName().equalsIgnoreCase(taskName)) {
                if (number == 1) {
                    item.setStatus("Pending");
                } else if (number == 2) {
                    item.setStatus("Completed");
                    item.setDateCompletion(LocalDate.now());
                }
                System.out.println("Status updated!");
                break;
            }
        }
    }

    public static void displayTaskList(ArrayList<ToDoList> toDoLists){
        System.out.println("Display all Tasks: ");
        for (ToDoList toDoList : toDoLists) {
            if(toDoList.getStatus().equals("Completed")){
                System.out.println("Task information: Name = "+ toDoList.getName() +", description= "+toDoList.getDescription()+ ", Status = "+toDoList.getStatus()+", Completion Date = "+toDoList.getDateCompletion());
            }else{
                System.out.println("Task information: Name = "+ toDoList.getName() +", description= "+toDoList.getDescription()+ ", Status = "+toDoList.getStatus());
            }
        }
    }

    public static void searchTaskList(ArrayList<ToDoList> toDoLists){
        System.out.println("Enter search text:");
        String searchText = sc.nextLine();
        for (ToDoList toDoList : toDoLists) {
            if(toDoList.getName().equalsIgnoreCase(searchText) || toDoList.getStatus().equalsIgnoreCase(searchText)){
                System.out.println("Task information: Name = "+ toDoList.getName() +", description= "+toDoList.getDescription()+ ", Status = "+toDoList.getStatus()+", Completion Date = "+toDoList.getDateCompletion());
            }
        }
    }
}
