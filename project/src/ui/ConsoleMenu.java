package ui;

import model.Status;
import service.TaskService;

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
}
