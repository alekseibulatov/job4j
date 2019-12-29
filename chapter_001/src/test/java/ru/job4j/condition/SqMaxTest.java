package ru.job4j.condition;
import org.junit.Test;
import static  org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void whenFirstMax(){
        SqMax check = new SqMax();
        int result = check.max(9,4,2, 6);
        assertThat(result, is(9));
    }
    @Test
    public void whenSecondMax(){
        SqMax check = new SqMax();
        int result = check.max(1,8,2, 6);
        assertThat(result, is(8));
    }
    @Test
    public void whenThirdMax(){
        SqMax check = new SqMax();
        int result = check.max(1,4,5, 3);
        assertThat(result, is(5));
    }
    @Test
    public void whenForthMax(){
        SqMax check = new SqMax();
        int result = check.max(1,5,2, 6);
        assertThat(result, is(6));
    }
}
