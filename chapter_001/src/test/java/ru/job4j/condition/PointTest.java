package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenX1EqualY1EqualX2AndY2Equal10ThenDistance10() {
        Point point = new Point();
        double result = point.distance(0,0,0,10);
        double expected = 10D;
        assertThat(result, is(expected));
    }
}