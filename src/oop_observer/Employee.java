package oop_observer;

public abstract class Employee implements Observer{
    private final TaskProgressCallback callback;
    private final String name;
    private final Task.Status taskStatus;

    public Employee(TaskProgressCallback callback, String name, Task.Status taskStatus) {
        this.callback = callback;
        this.name = name;
        this.taskStatus = taskStatus;
    }

    @Override
    public void handleTask(Task task) {
        System.out.println(getClass().getSimpleName() + " " + name  + " " + getDetail(task) + " is done task ");
        callback.updateTasks(task, getTaskWhenDone(task));
    }

    public final boolean canBeObserverForColumn(Column column) {
        return column.contains(taskStatus);
    }

    protected abstract Task getTaskWhenDone(Task task);

    protected abstract String getDetail(Task task);
}
