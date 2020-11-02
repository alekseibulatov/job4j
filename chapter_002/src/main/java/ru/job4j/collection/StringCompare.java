package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {


    @Override
    public int compare(String left, String right) {
        char[] ll = left.toCharArray();
        int value = -1;

        List<Character> l = new ArrayList<Character>();
        for (char x : ll) {
            l.add(x);
        }
        char[] rr = right.toCharArray();

        List<Character> r = new ArrayList<Character>();
        for (char z : rr) {
            r.add(z);
        }
        if (l.size() <= r.size()) {
            while (l.size() < r.size()) {
                l.add('0');
            }
            for (int i = 0; i < r.size(); i++) {
                value = Character.compare(l.get(i), r.get(i));
                if (value == 0) {
                    continue;
                } else
                    return value;
            }
        }
        if (r.size() < l.size()) {
            while (r.size() < l.size()) {
                r.add('0');
            }
            for (int i = 0; i < r.size(); i++) {
                value = Character.compare(l.get(i), r.get(i));
                if (value == 0) {
                    continue;
                } else
                    return value;
            }
        }
        return value;
    }
}
