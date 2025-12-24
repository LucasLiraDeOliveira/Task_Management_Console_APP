package repository;

import model.Task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskRepository {
    Set<Task> taskSet = new HashSet<>();

    public void add(Task task){
        taskSet.add(task);
    }

    public void remove(Task task){
        taskSet.remove(task);
    }

    public List<Task> findAll(){
        return List.copyOf(taskSet);
    }
}
