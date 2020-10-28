package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;


public class TrackerTest {


    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        ArrayList<Item> result = tracker.findById(item.getId());
        assertThat(result.get(0).getName(), is(item.getName()));
    }

    @Test
    public void whenFindAllItemsWithoutNull() {

        Tracker tracker = new Tracker();
        ArrayList<Item> items = new ArrayList<Item>(2);
        items.add(new Item("Bob"));
        items.add(new Item("Jack"));
        tracker.add(items.get(0));
        tracker.add(items.get(1));
        Assert.assertArrayEquals(items.toArray(), tracker.findAll().toArray());
    }


    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        ArrayList<Item> items = new ArrayList<Item>(2);
        items.add(new Item("Bob"));
        items.add(new Item("Jack"));
        tracker.add(items.get(0));
        tracker.add(items.get(1));
        ArrayList<Item> result = tracker.findByName("Bob");
        assertThat(items.get(0).getName(), is(result.get(0).getName()));
    }

    @Test

    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bob");
        tracker.add(item);
        ArrayList<Item> result = tracker.findById(item.getId());
        assertThat(result.get(0).getId(), is(item.getId()));
    }
}