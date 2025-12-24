package model;

import java.time.LocalDate;

public class Task {
    private String name;
    private String description;
    private Priority priority;
    private Status status;
    private LocalDate dueDate;





    public Task() {
    }

    public Task(String name, String description, Priority priority, Status status, LocalDate dueDate) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.dueDate = dueDate;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return name != null
                && task.name != null
                && name.equalsIgnoreCase(task.name);
    }

    @Override
    public int hashCode() {
        return name == null ? 0 : name.toLowerCase().hashCode();
    }






    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", dueDate=" + dueDate +
                '}';
    }
}

