package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {
    @Test

    public  void manWeightTest(){
double in = 130;
double expected = 34.5;
double out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 0.01);

    }
    @Test
    public void womanWeight(){
        double in = 150;
        double expected = 46;
        double out = Fit.womanWeight(in);
        Assert.assertEquals(expected, out, 0.01);

    }


}
