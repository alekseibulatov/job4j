package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> nameFind = x -> x.getName().contains(key);
        Predicate<Person> surnameFind = x -> x.getSurname().contains(key);
        Predicate<Person> phoneFind = x -> x.getPhone().contains(key);
        Predicate<Person> addressFind = x -> x.getAddress().contains(key);
        Predicate<Person> combine = nameFind.or(surnameFind.or(phoneFind.or(addressFind)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}






