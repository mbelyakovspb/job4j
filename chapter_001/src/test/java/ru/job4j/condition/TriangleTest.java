package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void whenSidesTriangleEqual234ThenPeriodEqual5() {
        Triangle triangle = new Triangle();
        double result = triangle.period(3, 3, 4);
        assertThat(result, closeTo(5, 0.1));
    }

    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Triangle triangle = new Triangle();
        double result = triangle.area(0, 0, 0, 2, 2, 0);
        assertThat(result, closeTo(2D, 0.1));
    }

    @Test
    public void whenTriangleExists() {
        Triangle triangle = new Triangle();
        boolean result = triangle.exist(3, 3, 4);
        assertThat(result, is(true));

    }
}