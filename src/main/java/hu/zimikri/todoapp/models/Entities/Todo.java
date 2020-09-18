package hu.zimikri.todoapp.models.Entities;

import javax.persistence.*;

@Entity
@Table(
        name = "todos",
        indexes = {
                @Index(columnList = "isCompleted")
        }
)
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private String task;
    private boolean isCompleted = false;
    @Column(length = 10)
    private String deadline;
    @Column(columnDefinition = "ENUM('low', 'medium', 'high') NOT NULL DEFAULT 'medium'")
    private String priority = "medium";

    public Todo() {

    }

    public Todo(long id, long userId, String task, boolean isCompleted, String deadline, String priority) {
        this.id = id;
        this.userId = userId;
        this.task = task;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
