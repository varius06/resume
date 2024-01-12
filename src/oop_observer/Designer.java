package oop_observer;


public class Designer extends Employee{

    protected Designer(TaskProgressCallback callback, String name) {
        super(callback, name, Task.Status.ASSEMBLING_REQUIREMENT);
    }

    @Override
    protected Task getTaskWhenDone(Task task) {
        return new Task(task.getId(),
                Task.Status.READY_TO_DO,
                task.getDescription(),
                getLink(task.getId()),
                "",
                "");
    }

    @Override
    protected String getDetail(Task task) {
        return " with taskId " + task.getId() + " and description " + task.getDescription() + " " + getLink(task.getId());
    }

    private String getLink(int taskId) {
        return "https://project/designer/" + taskId;
    }
}

