package oop_observer;

public interface Observable {
    void registerObservable(Observer observer);
    void removeObservable(Observer observer);
    void notifyObservers();
}
