package ru.job4j.stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixIntToList {
    public static void main(String[] args) {
        Integer[][] matrix = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Arrays.stream(matrix).flatMap(Arrays::stream).collect(Collectors.toList()).forEach(System.out::print);
        System.out.println();
        System.out.println("-----------");
        Stream.of(new Integer[][]{{1, 2, 3}, {4, 5, 8}}).flatMap(Arrays::stream).collect(Collectors.toList()).forEach(System.out::print);
    }
}
