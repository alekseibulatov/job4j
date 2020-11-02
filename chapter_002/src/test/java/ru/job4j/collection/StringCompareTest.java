package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringCompareTest {
    @Test
    public void whenStringAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare("Ivanov", "Ivanov");
        assertThat(rsl, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int rsl = compare.compare("Ivanov", "Ivanova");
        assertThat(rsl, lessThan(0));
    }
}
