package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class FitTest {

    @Test
    public void whenWeightMenEqualIdeal() {
        Fit fit = new Fit();
        double weight = fit.manWeight(174);
        assertThat(weight, closeTo(85.1, 0.1));
    }

    @Test
    public void whenWeightWomenEqualIdeal() {
        Fit fit = new Fit();
        double weight = fit.womenWeight(160);
        assertThat(weight, closeTo(57.5, 0.1));
    }
}