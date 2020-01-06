package ru.job4j.array;
import  org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    @Test
    public void whenArrayHas5Then0(){
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayHas4Then2(){
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 4};
        int value = 4;
        int result = find.indexOf(input, value);
        int expect = 2;
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayHas3ThenNot(){
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 4};
        int value = 3;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
    @Test
    public void whenFind3(){
        int[] input = new int[] {5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = FindLoop.indexOf1(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }
    @Test
    public void whenNotFind(){
        int[] input = new int[] {7, 2, 9, 4, 8};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = FindLoop.indexOf1(input, value, start, finish);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
