package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Map<Integer, String> hashmapOrigin = new HashMap<Integer, String>();
        Map<Integer, String>  hashmapLine = new HashMap<Integer, String>();
        String[] originArray = origin.split(" |\\.|\\,|\\!");
        String[] l = line.split(" ");
        int i = 0;
        for (String s : originArray) {
            hashmapOrigin.put(i, s);
            i++;
        }
        for (String d : l) {
            hashmapLine.put(i, d);
            i++;
        }
        boolean rsl = false;
        for (String z : l) {
            if (hashmapOrigin.containsValue(z)) {
                rsl = true;
            } else {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
