package oop_todo;

public class TestToDo {
    public static void main(String[] args) {
        TaskFactory factory = new TaskFactory();
        TaskProgressCallback taskProgressCallback = new TaskProgressCallback() {
            @Override
            public void updateTask(Task task) {

                factory.updateTask(task);
            }
        };

        EmployeeChain chain = new EmployeeChain(new Designer(taskProgressCallback, "Alex"));
        EmployeeChain next = new EmployeeChain(new Programmer(taskProgressCallback, "Evgen"));
        EmployeeChain last = new EmployeeChain(new Tester(taskProgressCallback, "Tany"));

        chain.setEmployeeChain(next);
        next.setEmployeeChain(last);

        while (true) {
            chain.doTask(factory.getTask());
        }
    }
}
