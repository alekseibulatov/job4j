package ru.job4j.tracker;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByUpNameItem implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }

  //  public static List<Item>  sort(List<Item> data) {
   //    return  Collections.sort(data, new SortByUpNameItem());
  //  }


}
