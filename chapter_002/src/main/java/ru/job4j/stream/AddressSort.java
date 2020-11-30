package ru.job4j.stream;

import java.util.Comparator;

public class AddressSort implements Comparator<Profile> {
    @Override
    public int compare(Profile first, Profile second) {
        return first.getAddress().getCity().compareTo(second.getAddress().getCity());
    }

}
