package ru.job4j.collection;

import java.util.Comparator;


public class StringCompare implements Comparator<String> {


    @Override
    public int compare(String left, String right) {
        int l = Math.min(left.length(), right.length());
        int rsl = -1;

        for (int i = 0; i < l; i++) {
            char q = left.charAt(i);
            char w = right.charAt(i);
            rsl = Character.compare(q, w);
            if (rsl != 0) {
                return rsl;
            } else if (rsl == 0 && i == l - 1) {
                break;
            } else if (rsl == 0) {
                continue;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
