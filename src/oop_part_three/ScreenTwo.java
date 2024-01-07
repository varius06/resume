package oop_part_three;

public class ScreenTwo {
    private final Data.Read<Person> repository;

    public ScreenTwo(Data.Read<Person> read) {
        this.repository = read;
    }

    public void show(Show<String> monitor) {
        monitor.show(repository.read().toString());
    }
}

interface Show<T> {
    void show(T data);
}
