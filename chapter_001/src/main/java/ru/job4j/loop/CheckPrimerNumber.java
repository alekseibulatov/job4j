package ru.job4j.loop;

public class CheckPrimerNumber {
    public static boolean check(int num) {
        boolean prime = true;
        for (int i = 2; num > i; i++) {
            if ((num % i == 0)) {
                prime = false;
                break;
            }
        }
        return  prime;
    }
}
