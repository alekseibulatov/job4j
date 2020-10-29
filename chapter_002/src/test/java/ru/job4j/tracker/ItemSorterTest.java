package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.collection.ListSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ItemSorterTest {
    @Test
    public void whenSortByUpNameItem() {

        List<Item> input = Arrays.asList(new Item("a"), new Item("c"), new Item("v"), new Item("d"));
        Collections.sort(input, new SortByUpNameItem());
        List<Item> expect = Arrays.asList(new Item("a"), new Item("c"), new Item("d"), new Item("v"));
        Assert.assertEquals(expect, input);
    }

    @Test
    public void whenSortByDownNameItem() {

        List<Item> input = Arrays.asList(new Item("a"), new Item("c"), new Item("v"), new Item("d"));
        Collections.sort(input, new SortByDownNameItem());
        List<Item> expect = Arrays.asList(new Item("v"), new Item("d"), new Item("c"), new Item("a"));
        Assert.assertEquals(expect, input);
    }

}
