package oop_observer;

public class Programmer extends Employee{

    protected Programmer(TaskProgressCallback callback, String name) {
        super(callback, name, Task.Status.READY_TO_DO);
    }

    @Override
    protected Task getTaskWhenDone(Task task) {
        return new Task(task.getId(),
                Task.Status.READY_FROM_TESTING,
                task.getDescription(),
                task.getLinkDesigner(),
                getLink(task.getId()),
                "");
    }

    @Override
    protected String getDetail(Task task) {
        return "with taskId " + task.getId() + " and description " + task.getDescription() + " " + getLink(task.getId());
    }

    private String getLink(int taskId) {
        return "https://project/programmer/" + taskId;
    }
}
