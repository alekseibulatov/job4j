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
        return (a + b + c) / 2;
    }

    public double area() {
        double rs1 = -1;
        double a = this.first.distance(this.second);
        double b = this.first.distance(this.third);
        double c = this.second.distance(this.third);
        double p = this.period(a, b, c);
        if (this.exist(a, b, c)) {

            rs1 = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return rs1;
    }

    public boolean exist(double a, double c, double b) {
        if ((a + b >= c) && (b + c >= a) && (c + a >= b)) {
            return true;
        } else
            return false;
    }
}





