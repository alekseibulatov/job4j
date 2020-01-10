package ru.job4j.loop;

public class Factorial {
    public int calc(int n) {
        int result = 1;
        for (; n > 0; n = n - 1) {
            result = result * n;
        }
        return result;
    }
}
