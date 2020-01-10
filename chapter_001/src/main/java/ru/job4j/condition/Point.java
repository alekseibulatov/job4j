package ru.job4j.condition;


public class Point {
    public static double distance(int x1, int y1, int x2, int y2) {
         double a = x2 - x1;
         double b = y2 - y1;
         double a1 = Math.pow(a, 2);
         double b1 = Math.pow(b, 2);
                return  Math.sqrt(a1 + b1);
    }
    public static void main(String[] args) {
        double result = distance(0, 0, 2, 0);
        System.out.println("result (0, 0) to (2, 0) " + result);
       double r = distance(5, 9, 6, 7);
           System.out.println("result (5, 4) to (6, 7) " + r);
    }
}
