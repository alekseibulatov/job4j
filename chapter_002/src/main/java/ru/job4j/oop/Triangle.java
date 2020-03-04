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
    public double period(double a, double b, double c) {
        return -1;

    }
    public double area() {
        double rs1 = -1;
        double a = first.distance(second);
        double b = first.distance(third);
        double c = second.distance(third);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            // написать формулу для расчета площади треугольника.
            rs1 = -1;
        }
        return rs1;
    }
    private boolean exist(double a, double c, double b) {
        return false;
    }
}



