package oop_observer;

public interface TaskProgressCallback {
    void updateTasks(Task oldTask, Task newTask);
}
