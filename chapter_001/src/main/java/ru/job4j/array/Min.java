package ru.job4j.array;

public class Min {
    public static int findMin(int[] array) {
        int min = array[0];
        for (int index = 1; index <= array.length - 1; index++) {
            if (array[0] != array[index]) {
                min = array[index] < min ? array[index] : min;
            } else   min = array[0];
        }
        return min;
    }
}
