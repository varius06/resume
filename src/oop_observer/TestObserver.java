package oop_observer;

import java.util.ArrayList;
import java.util.List;

public class TestObserver {

    public static void main(String[] strings) {
        TaskFactory factory = new TaskFactory();
        List<Employee> employees = new ArrayList<>();
        TaskProgressCallback callback = new CallbackImpl(factory);
        employees.add(new Designer(callback, "Alex"));
        employees.add(new Programmer(callback, "Pavel"));
        employees.add(new Tester(callback, "Danil"));
        factory.addEmployees(employees);
        factory.start();
    }
}
