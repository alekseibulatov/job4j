package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static  org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenMax1ToThen2() {
        int result = Max.max(4, 2);
        assertThat(result, is(4));
    }
    @Test
    public void whenMax1ToThen1() {
        int result = Max.max(7, 7);
        assertThat(result, is(7));
    }
    @Test
    public void whenMaxToThree() {
        int result = Max.max(2, 5, 4);
        assertThat(result, is(5));
    }
    @Test
    public void whenMaxToFour() {
        int result = Max.max(5, 8, 2, 9);
        assertThat(result, is(9));
    }
}
