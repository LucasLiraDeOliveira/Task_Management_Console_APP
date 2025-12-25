package ui;

import model.Priority;
import model.Status;
import model.Task;
import service.TaskService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {
    private TaskService service;
    private Scanner scanner = new Scanner(System.in);



    public ConsoleMenu(TaskService taskService) {
        this.service = taskService;
    }



    public void start(){
        boolean running = true;

        System.out.println("Do you want to add some task examples to manipulate the app a little? [YES - NO]");
        if (scanner.next().toLowerCase() == "yes"){
            //add 5 example tasks
        } else {
            System.out.println("Okok! Console app starting empty");
        }

        while (running){
            System.out.println("\n\n--- Personal Task Manager ---");
            System.out.println("1 - Add a Task\n2 - Remove a task\n3 - List all tasks\n4 - List tasks by a " +
                    "specific status\n5 - List tasks by a specific Priority\n6 - Change Status of a Task\n7 - Change " +
                    "Priority of a Task\n0 - To exit the APP");
            int option = readOption();


            switch (option) {
                case 1 -> AddTask();
                case 2 -> RemoveTask();
                case 3 -> ListAllTasks();
                case 4 -> ListTaskFilteredByStatus();
                case 5 -> ListTaskFilteredByPriority();
                case 6 -> ChangeStatus();
                case 7 -> ChangePriority();
                case 0 -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }






    private int readOption() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }


    private void RemoveTask(){
        System.out.println("Which task do you want to remove?");
        String taskName = scanner.nextLine().toLowerCase();
        boolean condition = true;

        while (condition){
            System.out.println("nome da task: " + taskName);
            condition = false;
        }

        service.removeTask(taskName);
        System.out.println("Task removed!");
    }


    private void AddTask(){
        System.out.println("Name of the Task:");
        String name = scanner.nextLine().toLowerCase();

        System.out.println("Description of the Task:");
        String description = scanner.nextLine().toLowerCase();


        // Priority atribute part:
        scanner.nextLine(); // clear leftover newline
        Priority priority = null;

        while (priority == null) {
            System.out.print("What's the priority level of this Task (LOW, MEDIUM, HIGH):");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) continue;

            try {
                priority = Priority.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid priority. Try again.");
            }
        }


        System.out.println("What's the time limit for this Task?");
        System.out.println("Year (YYYY format): ");
        int year = scanner.nextInt();

        System.out.println("Month (MM format): ");
        int month = scanner.nextInt();

        System.out.println("Day (DD format): ");
        int day = scanner.nextInt();

        LocalDate dueDate = LocalDate.of(year, month, day);

        Task newTask = new Task(
                name,
                description,
                priority,
                Status.TODO,
                dueDate
        );

        service.addTask(newTask);
        System.out.println("Task added!");
    }


    private void ListAllTasks(){
        List<Task> tasks = service.listAllTasks();
        tasks.forEach(System.out::println);
    }


    private void ListTaskFilteredByStatus(){
        Status status = checkStatus();
        List<Task> tasksFiltereed = service.listByStatus(status);
        tasksFiltereed.forEach(System.out::println);
    }


    private void ListTaskFilteredByPriority(){
        Priority priority = checkPriority();
        List<Task> tasksFiltereed = service.listByPriority(priority);
        tasksFiltereed.forEach(System.out::println);
    }


    private void ChangeStatus(){
        Status newStatus;
        System.out.println("Which task do you want to change the Status?");
        String taskName = scanner.nextLine().toLowerCase();

        newStatus = checkStatus();

        service.changeStatus(taskName, newStatus);
        System.out.println("Task's status updated!");
    }


    private Status checkStatus(){
        boolean condition = true;
        Scanner checkScanner = new Scanner(System.in);
        String statusString;
        Status newStatus = null;

        while (condition){
            System.out.println("What's the new Status you want it? (TODO - ONGOING - DONE)");
            statusString = checkScanner.nextLine().toUpperCase();

            switch (statusString) {
                case "TODO" -> newStatus = Status.TODO;
                case "ONGOING" -> newStatus = Status.ONGOING;
                case "DONE" -> newStatus = Status.DONE;
                default -> newStatus = Status.WRONG;
            };

            if (newStatus.equals(Status.WRONG)) {
                System.out.println("Wrong status typed! Please write one of the correct options!");
                continue;
            }
            condition = false;
        }

        return newStatus;
    }


    private void ChangePriority(){
        Priority newPriority;
        System.out.println("Which task do you want to change the Status?");
        String taskName = scanner.nextLine().toLowerCase();

        newPriority = checkPriority();

        service.changePriority(taskName, newPriority);
        System.out.println("Task's status updated!");
    }


    private Priority checkPriority(){
        boolean condition = true;
        Scanner checkScanner = new Scanner(System.in);
        String priorityString;
        Priority newPriority = null;

        while (condition){
            System.out.println("What's the new Priority you want to give it? (LOW - MEDIUM - HIGH)");
            priorityString = checkScanner.nextLine().toUpperCase().trim();

            switch (priorityString) {
                case "LOW" -> newPriority = Priority.LOW;
                case "MEDIUM" -> newPriority = Priority.MEDIUM;
                case "HIGH" -> newPriority = Priority.HIGH;
                default -> newPriority = Priority.WRONG;
            };

            if (newPriority.equals(Status.WRONG)) {
                System.out.println("Wrong status typed! Please write one of the correct options!");
                continue;
            }
            condition = false;
        }

        return newPriority;
    }
}
