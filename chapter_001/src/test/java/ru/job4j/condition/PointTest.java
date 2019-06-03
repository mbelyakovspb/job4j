package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenX1EqualY1EqualX2AndY2Equal10ThenDistance10() {
        Point first = new Point(0, 0);
        Point second = new Point(0, 10);
        double result = first.distance(second);
        first.info();
        second.info();
        System.out.println(String.format("Result is %s", result));
        assertThat(result, is(10D));
    }
    @Test
    public void whenX1Equal1Y1Equal2Z1Equal3X2EqualMinus7Y2EqualMinus2Z2Equal4Then9() {
        Point first = new Point(1, 2, 3);
        Point second = new Point(-7, -2, 4);
        double result = first.distance3d(second);
        first.info3d();
        second.info3d();
        System.out.println(String.format("Result is %s", result));
        assertThat(result, is(9D));
    }
    @Test
    public void whenCheckItSelf() {
        Point point = new Point(0, 0);
        double result = point.distance(point);
        assertThat(result, is(0D));
    }
    @Test
    public void whenShowInfo() {
        Point first = new Point(1, 1);
        first.info();
        Point second = new Point(2, 2);
        second.info();
        Point first3d = new Point(1, 2, 3);
        first3d.info3d();
        Point second3d = new Point(-7, -2, 3);
        second3d.info3d();
    }
}