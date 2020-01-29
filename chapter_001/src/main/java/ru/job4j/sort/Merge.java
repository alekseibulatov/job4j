package ru.job4j.sort;

import java.util.Arrays;

public class Merge {
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int a = 0;
        int b = 0;
            for (int i = 0; i < left.length + right.length; i++) {
                    if (a == left.length) {
                        rsl[i] = right[b];
                        b++;
                    } else if (b == right.length) {
                        rsl[i] = left[a];
                        a++;
                    } else  if (left[a] < right[b]) {
                        rsl[i] = left[a];
                        a++;
                    } else {
                        rsl[i] = right[b];
                        b++;
                    }
            }
                return rsl;
    }
            public static void main(String[] args) {
                Merge process = new Merge();
                int[] rsl = process.merge(new int[]{1, 3, 5}, new int[]{2, 4});
                System.out.println(Arrays.toString(rsl));
            }
}


