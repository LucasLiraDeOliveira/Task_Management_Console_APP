package ui;

import model.Priority;
import model.Status;
import model.Task;
import service.TaskService;

import java.time.LocalDate;
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
            System.out.println("1 - Add a Task\n2 - List all tasks\n3 - List tasks with TODO " +
                    "status\n4 - List tasks with ONGOING status\n5 - List tasks with DONE status\n0 - To exit the " +
                    "APP");
            int option = readOption();


            switch (option) {
                case 1:
                    AddTask();
                    break;
                case 2:
                    ListAllTasks();
                    break;
                case 3:
                    ListTaskFiltered(Status.TODO);
                    break;
                case 4:
                    ListTaskFiltered(Status.ONGOING);
                    break;
                case 5:
                    ListTaskFiltered(Status.DONE);
                    break;
                case 0:
                    running = false;
                    break;
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
}
