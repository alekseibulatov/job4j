package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Profile> pr = new ArrayList<>();
        pr.add(new Profile(new Address("Санкт-Петербург", "ул. Фомина", 4, 2), "Андрей"));
        pr.add(new Profile(new Address("Москва", "ул. Парковая", 6, 3), "Сергей"));
        pr.add(new Profile(new Address("Брянск", "ул. Лабутова", 7, 67), "Маша"));
        pr.add(new Profile(new Address("Екатеринбург", "ул. Тихорецкая", 48, 24), "Света"));
        for (Profile s : pr) {
            System.out.println(s.toString());
        }
        System.out.println("------------------");
        List<Address> w = collect(pr);
        for (Address q : w) {
            System.out.println(q.toString());
        }
    }
}
