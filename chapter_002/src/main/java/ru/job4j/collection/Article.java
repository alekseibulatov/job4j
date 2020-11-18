package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> hashmapOrigin = new HashSet<>();
        Set<String> hashmapLine = new HashSet<>();
        origin = origin.replaceAll("\\p{P}", " ");
        String[] originArray = origin.split(" ");
        String[] l = line.split(" ");
        hashmapOrigin.addAll(Arrays.asList(originArray));
        hashmapLine.addAll(Arrays.asList(l));
        boolean rsl;
        rsl = hashmapOrigin.containsAll(hashmapLine);
        return rsl;
    }
}
