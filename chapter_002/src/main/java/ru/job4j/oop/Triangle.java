package ru.job4j.oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }
    public double period(Triangle that) {
        return (this.first + this.second + this.third)/2;

    }

    public static void main(String[] args) {
        Triangle a = new Triangle(0.0, 2.4, 3.3);

    }


}
