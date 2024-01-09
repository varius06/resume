package oop_todo;

public abstract class Employee {
    private final TaskProgressCallback callback;
    private final String name;
    private final Task.Status taskStatus;

    protected Employee(TaskProgressCallback callback, String name, Task.Status taskStatus) {
        this.callback = callback;
        this.name = name;
        this.taskStatus = taskStatus;
    }

    public void doTask(Task task) {
        System.out.println(getClass().getSimpleName() + " " + name  + getDetail(task) + " is done task ");
        callback.updateTask(getTaskWhenDone(task));
    }

    public Task.Status getTaskStatus() {
        return taskStatus;
    }

    protected abstract Task getTaskWhenDone(Task task);

    protected abstract String getDetail(Task task);
}
