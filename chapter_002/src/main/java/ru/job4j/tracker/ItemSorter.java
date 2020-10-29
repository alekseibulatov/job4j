package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(new Item("a"), new Item("c"), new Item("v"), new Item("d"));
        System.out.println(items);
        Collections.sort(items, new SortByUpNameItem());
        System.out.println(items);
        Collections.sort(items, new SortByDownNameItem());
        System.out.println(items);
    }
}
