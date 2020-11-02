package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int index = -1;
        int value = -1;
        if (left.length() > right.length()) {
            for (int i = 0; i < right.length(); i++) {
                index = i;
            }
          value =  Character.compare(left.charAt(index), right.charAt(index));
        } else
        if (left.length() < right.length()) {
            for (int i = 0; i < left.length(); i++) {
                index = i;


                value = Integer.compare(right.charAt(index), left.charAt(index));
            }

        } else
        if (left.length() == right.length()) {
            for (int i = 0; i < left.length(); i++) {
                index = i;
            }
           value = Character.compare(right.charAt(index), left.charAt(index));
        }
        return value;
    }
}



