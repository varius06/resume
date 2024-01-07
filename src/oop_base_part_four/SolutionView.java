package oop_base_part_four;

public class SolutionView {
    public static void main(String[] args) {
        Screen1Fragment screen1Fragment = new Screen1Fragment(new Screen1Presenter());
        screen1Fragment.onResume(new Screen1View());
    }
}
