package ru.job4j.collection;

import java.util.Comparator;


public class StringCompare implements Comparator<String> {


    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            char q = left.charAt(i);
            char w = right.charAt(i);
            int rsl = Character.compare(q, w);
            if (rsl != 0) {
                return rsl;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
