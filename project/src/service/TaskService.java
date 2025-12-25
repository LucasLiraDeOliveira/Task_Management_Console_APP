package service;

import model.Priority;
import model.Status;
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



    public void removeTask(String taskName){
        repository.findAll().stream()    // Stream<Task>
                .filter(task -> task.getName().equalsIgnoreCase(taskName))  //filter returns a Stream
                .findFirst()   //ends the stream, returns an Optional (Optional → value may exist or not)
                .ifPresent(repository::remove);   //executes only if value exists
    }



    public List<Task> listAllTasks(){
        return repository.findAll();
    }



    public List<Task> listByStatus(Status status){
        return repository.findAll()
                .stream()
                .filter(task -> task.getStatus() == status)
                .toList();
    }



    public List<Task> listByPriority(Priority priority){
        return repository.findAll()
                .stream()
                .filter(task -> task.getPriority() == priority)
                .toList();
    }



    public void changeStatus(String taskName, Status newStatus){
        repository.findAll().stream()
                .filter(task -> task.getName().equalsIgnoreCase(taskName))
                .findFirst()
                .ifPresent(task -> task.setStatus(newStatus));
    }



    public void changePriority(String taskName, Priority newPriority){
        repository.findAll().stream()
                .filter(task -> task.getName().equalsIgnoreCase(taskName))
                .findFirst()
                .ifPresent(task -> task.setPriority(newPriority));
    }
}
