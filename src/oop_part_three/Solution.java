package oop_part_three;

public class Solution {
    public static void main(String[] args) {
        Data.Mutable<Person> repository = new Data.LocalCache<>();
        ScreenOne one = new ScreenOne(repository);
        ScreenTwo two = new ScreenTwo(repository);

        one.saveName("Alex");
        two.show(new Show<String>() {
            @Override
            public void show(String data) {
                System.out.println(data);
            }
        });
    }
}
