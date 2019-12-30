package ru.job4j.loop;
import  org.junit.Test;
import static  org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToThenThirty(){
        Counter check = new Counter();
        int sum = check.add(1, 10);
        assertThat(sum, is(30));
    }
}