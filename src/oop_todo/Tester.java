package oop_todo;

public class Tester extends Employee{
    protected Tester(TaskProgressCallback callback, String name) {
        super(callback, name, Task.Status.READY_FROM_TESTING);
    }

    @Override
    protected Task getTaskWhenDone(Task task) {
        return new Task(task.getId(),
                Task.Status.DONE,
                task.getDescription(),
                task.getLinkDesigner(),
                task.getLinkProgrammer(),
                getLink(task.getId()));
    }

    @Override
    protected String getDetail(Task task) {
        return "with taskId " + task.getId() + " and description " + task.getDescription() + " " + getLink(task.getId());
    }

    private String getLink(int taskId) {
        return "https://project/programmer/" + taskId;
    }
}
