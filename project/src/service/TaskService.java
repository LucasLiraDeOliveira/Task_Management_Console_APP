package service;

import model.Task;
import repository.TaskRepository;

import java.util.List;

public class TaskService {
    TaskRepository repository;


    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }



    public void addTask(Task task){
        repository.add(task);
    }



    public List<Task> listAllTasks(){
        return repository.findAll();
    }
}
