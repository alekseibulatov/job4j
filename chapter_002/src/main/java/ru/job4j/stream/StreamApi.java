package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(5);
        list.add(-7);
        list.add(9);
        list.stream().filter(x -> x > 0).collect(Collectors.toList()).forEach(System.out :: println);
    }
}
