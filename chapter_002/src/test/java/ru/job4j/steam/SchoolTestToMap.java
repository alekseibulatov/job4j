package ru.job4j.steam;

import org.junit.Test;
import ru.job4j.stream.School;
import ru.job4j.stream.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SchoolTestToMap {
    private List<Student> students = new ArrayList<>();

    @Test
    public void convertToMapTest() {
        School sc = new School();
        Student a1 = new Student(10, "Surname1");
        Student a2 = new Student(20, "Surname2");
        Student a3 = new Student(30, "Surname3");
        Student a4 = new Student(40, "Surname4");
        students.add(a1);
        students.add(a2);
        students.add(a3);
        students.add(a4);
        Map<String, Student> rsl = sc.convertToMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put(a1.getSurname(), a1);
        expected.put(a2.getSurname(), a2);
        expected.put(a3.getSurname(), a3);
        expected.put(a4.getSurname(), a4);
        assertEquals(rsl, expected);


    }
}
