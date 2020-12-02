package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FunctionDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionDiapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = List.of(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = FunctionDiapason.diapason(5, 8, x -> 2 * (x * x) + 1);
        List<Double> expected = List.of(51D, 73D, 99D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunction() {
        List<Double> result = FunctionDiapason.diapason(5, 8, x -> Math.pow(2, x));
        List<Double> expected = List.of(32D, 64D, 128D);
        assertThat(result, is(expected));
    }
}

