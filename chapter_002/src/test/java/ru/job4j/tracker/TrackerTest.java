package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;


public class TrackerTest {


    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindAllItemsWithoutNull() {

        Tracker tracker = new Tracker();
        Item[] items = new Item[2];
        items[0] = new Item("Bob");
        items[1] = new Item("Jack");
        tracker.add(items[0]);
        tracker.add(items[1]);
        Assert.assertArrayEquals(items, tracker.findAll());
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[2];
        items[0] = new Item("Bob");
        items[1] = new Item("Jack");
        tracker.add(items[0]);
        tracker.add(items[1]);
        Item[] result = tracker.findByName("Bob");
        assertThat(items[0].getName(), is(result[0].getName()));
    }

    @Test

    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bob");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getId(), is(item.getId()));
    }
}