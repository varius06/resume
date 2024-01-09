package oop_todo;

public class EmployeeChain {

    private final Employee employee;
    private EmployeeChain employeeChain;


    public EmployeeChain(Employee employee) {
        this.employee = employee;
    }

    public void setEmployeeChain(EmployeeChain employeeChain) {
        this.employeeChain = employeeChain;
    }

    public void doTask(Task task) {
        if(task.getStatus() == employee.getTaskStatus()) {
            employee.doTask(task);
        } else if (employeeChain != null) {
            employeeChain.doTask(task);
        } else {
            throw new IllegalArgumentException("task can't be handed");
        }
    }
}
