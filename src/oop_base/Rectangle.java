package oop_base;

public class Rectangle extends Figure{
    protected Rectangle(double a, double b) {
        super("Rectangle", new double[]{a, b});
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 2 * super.getPerimeter();
    }
}
