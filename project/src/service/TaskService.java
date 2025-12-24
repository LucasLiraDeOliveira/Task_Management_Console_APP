package service;

import model.Task;
import repository.TaskRepository;

public class TaskService {
    TaskRepository repository;


    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }



    public void addTask(Task task){
        repository.add(task);
    }
}
