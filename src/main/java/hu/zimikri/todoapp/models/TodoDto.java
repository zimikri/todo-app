package hu.zimikri.todoapp.models;

public class TodoDto {
    private long id;
    private String task;
    private boolean isCompleted;
    private String deadline;
    private String priority;

    public TodoDto(Todo todo) {
        this.id = todo.getId();
        this.task = todo.getTask();
        this.isCompleted = todo.isCompleted();
        this.deadline = todo.getDeadline();
        this.priority = todo.getPriority();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
