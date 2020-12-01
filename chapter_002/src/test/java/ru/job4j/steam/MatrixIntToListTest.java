package ru.job4j.steam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import ru.job4j.stream.MatrixIntToList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixIntToListTest {

    @Test
    public void whenConvertMatrixToList() {
        Integer[][] matrix = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrixIntToList ob = new MatrixIntToList();
        List<Integer> rsl = ob.convertMatrixToList(matrix);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);
        assertThat(rsl, is(expected));
    }
}
