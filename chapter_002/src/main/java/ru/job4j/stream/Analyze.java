package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
     * Метод вычисляет общий средний балл.
     *
     * @param stream - ученики
     * @return -  средний балл
     */

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * Метод вычисляет средний балл ученика по его предметам
     *
     * @param stream - ученики
     * @return - список из объектов Tuple (имя ученика и средний балл)
     */

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.getName(), x.getSubjects().stream().mapToInt(Subject::getScore).
                average()
                .orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * Метод вычисляет средний балл по всем предметам для каждого ученика
     *
     * @param stream - ученики
     * @return - список из объектов Tuple (название предмета и средний балл)
     */

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(x -> x.getSubjects()
                        .stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Метод возвращает лучшего ученика.
     * Лучшим считается ученик с наибольшим баллом по всем предметам.
     *
     * @param stream - ученики
     * @return - возвращает лучшего ученика
     */

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.getName(), x.getSubjects().stream()
                .mapToInt(Subject::getScore)
                .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    /**
     * Метод возвращает предмет с наибольшим баллом для всех студентов.
     *
     * @param stream - ученики
     * @return -обект  Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
     */

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .max(Comparator.comparing(Tuple::getScore)).orElse(null);
    }
}
