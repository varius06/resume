package oop_observer;

import java.util.ArrayList;
import java.util.List;

public class Column implements Observable{
    private Task.Status status;
    private final List<Observer> observers = new ArrayList<>();
    private final List<Task> tasks = new ArrayList<>();

    public Column(Task.Status status) {
        this.status = status;
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers();
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public boolean contains(Task.Status status) {
        return this.status == status;
    }

    @Override
    public void registerObservable(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObservable(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.handleTask(tasks.get(0));
        }
    }
}
