package oop_base_one;

public class TestFigure {
    public static void main(String[] args) {
        Figure[] figures = new Figure[3];
        figures[0] = new Circle(2);
        figures[1] = new Rectangle(2, 2);
        figures[2] = new Triangle(2, 2, 9);

        for (Figure figure: figures) {
            System.out.println(figure.type + " Perimeter: " + figure.getPerimeter() + " " + "Area: " + figure.getArea());
        }
    }
}
