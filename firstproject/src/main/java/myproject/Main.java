package myproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.exercise2.DataValidation;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<ToDoList> todoList = new ArrayList<>();
        DataValidation dataValidation = new DataValidation();

        // Add new "Task 1" to the todo list
        todoList.add(new ToDoList("Task 1", "do java exercise", "inprogress", null));
        todoList.add(new ToDoList("Task 2", "do java exercise", "inprogress", null));
        todoList.add(new ToDoList("Task 3", "do java exercise", "inprogress", null));

        todoList.add(new PriorityTask("PrioTask 1", "java exercise", "inprogress", null, "low"));
        todoList.add(new DeadlineTask("DeadLine 1", "description 1", "Pending", null, LocalDate.of(2025, 3, 20)));
        //displayTaskList(todoList);
        //searchTaskList(todoList);

        // Remove a task from the list
        // deleteTask(todoList);

        // Update the status of a task (pending/completed).
        // updateStatus(todoList);
        System.out.println("Nhap Email: ");
        String email = sc.nextLine();
        if (dataValidation.isValidEmail(email)) {
            System.out.println("Email Valid!");
        } else{
            System.out.println("Invalid");
        }
        
        sc.close();
    }

    public static void deleteTask(ArrayList<ToDoList> todoList) {
        System.out.println("Input Task name to delete: ");
        String taskName = sc.nextLine();
        for (int i = 0; i < todoList.size(); i++) {
            if (todoList.get(i).getName().equals(taskName)) {
                todoList.remove(i);
            }
        }
    }

    public static void updateStatus(ArrayList<ToDoList> todoLists) {
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

    public static void displayTaskList(ArrayList<ToDoList> toDoLists) {
        System.out.println("Display all Tasks: ");
        for (ToDoList toDoList : toDoLists) {
            if (toDoList instanceof PriorityTask) {
                PriorityTask item = (PriorityTask) toDoList;
                System.out.println("Task information: Name = " + item.getName() + ", description= "
                        + item.getDescription() + ", Status = " + item.getStatus() + ", Completion Date= "
                        + item.getDateCompletion() + ", Priority= " + item.getPriority());
            } else if (toDoList instanceof DeadlineTask) {
                DeadlineTask item2 = (DeadlineTask) toDoList;
                System.out.println("Task information: Name = " + item2.getName() + ", description= "
                        + item2.getDescription() + ", Status = " + item2.getStatus() + ", Completion Date= "
                        + item2.getDateCompletion() + ", deadlineDate= " + item2.getDeadlineDate());
            } else {
                System.out.println("Task information: Name = " + toDoList.getName() + ", description= "
                        + toDoList.getDescription() + ", Status = " + toDoList.getStatus() + ", Completion Date= "
                        + toDoList.getDateCompletion());
            }
        }
    }

    public static void searchTaskList(ArrayList<ToDoList> toDoLists) {
        System.out.println("Enter search text:");
        String searchText = sc.nextLine();
        for (ToDoList toDoList : toDoLists) {
            if (toDoList.getName().equalsIgnoreCase(searchText) || toDoList.getStatus().equalsIgnoreCase(searchText)) {
                System.out.println("Task information: Name = " + toDoList.getName() + ", description= "
                        + toDoList.getDescription() + ", Status = " + toDoList.getStatus() + ", Completion Date = "
                        + toDoList.getDateCompletion());
            }
        }
    }
}
