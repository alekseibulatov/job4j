package ru.job4j.condition;


import  org.junit.Assert;
import  org.junit.Test;

public class PointTest {
    @Test
    public  void distance1() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double expected = 2.0;
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.0);
    }
    @Test
    public void distance3D() {
        Point a = new Point(0, 0, 1);
        Point b = new Point(2, 0, 0);
        double expected = 2.23;
        double out = a.distance3D(b);
        Assert.assertEquals(expected, out, 0.1);

    }
}
