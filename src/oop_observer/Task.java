package oop_observer;

public class Task {
    private final int id;

    private Task.Status status;

    private final String description;

    private final String linkDesigner;

    private final String linkProgrammer;

    private final String linkTester;

    public Task(int id, Task.Status status, String description, String linkDesigner, String linkProgrammer, String linkTester) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.linkDesigner = linkDesigner;
        this.linkProgrammer = linkProgrammer;
        this.linkTester = linkTester;
    }

    public int getId() {
        return id;
    }

    public Task.Status getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getLinkDesigner() {
        return linkDesigner;
    }

    public String getLinkProgrammer() {
        return linkProgrammer;
    }

    public String getLinkTester() {
        return linkTester;
    }

    enum Status {
        ASSEMBLING_REQUIREMENT,
        READY_TO_DO,
        READY_FROM_TESTING,
        DONE
    }
}
