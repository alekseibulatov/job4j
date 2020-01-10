package ru.job4j.loop;
import  org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CheckPrimerNumberTest {
    @Test
    public void when5() {
        boolean rs1 = CheckPrimerNumber.check(5);
        assertThat(rs1, is(true));
    }
    @Test
    public void when4() {
        boolean rs1 = CheckPrimerNumber.check(4);
        assertThat(rs1, is(false));
    }
    @Test
    public void when2() {
        boolean rs1 = CheckPrimerNumber.check(2);
        assertThat(rs1, is(true));
    }
}
