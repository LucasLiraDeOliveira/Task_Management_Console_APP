package ui;

import service.TaskService;

public class ConsoleMenu {
    private TaskService service;


    public ConsoleMenu(TaskService taskService) {
        this.service = taskService;
    }
}
