package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void whenTwoPlusTwoThenFour() {
        Calculator calculator = new Calculator();
        double result = calculator.add(2D, 2D);
        double expected = 4D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoSubstructTwoThenZero() {
        Calculator calculator = new Calculator();
        double result = calculator.sub(2D, 2D);
        double expected = 0D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenThreeMultiplyThreeThenNine() {
        Calculator calculator = new Calculator();
        double result = calculator.multiplication(3D, 3D);
        double expected = 9D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoDivideTwoThenOne() {
        Calculator calculator = new Calculator();
        double result = calculator.div(2D, 2D);
        double expected = 1D;
        assertThat(result, is(expected));

    }
}