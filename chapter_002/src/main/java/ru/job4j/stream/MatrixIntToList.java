package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixIntToList {

    public List<Integer> convertMatrixToList(Integer[][] input) {
        return Arrays.stream(input).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
