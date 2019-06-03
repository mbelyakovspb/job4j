package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenNumberTwoAndOneThenTwoMore() {
        Max max = new Max();
        int result = max.max(2, 1);
        assertThat(result, is(2));
    }
    @Test
    public void whenFirstEqual10SecondEqual15ThirdEqual35Then35() {
        Max max = new Max();
        int result = max.max(10, 15, 35);
        assertThat(result, is(35));
    }
    @Test
    public void whenFirstEqual10SecondEqual15ThirdEqual35Fourth52Then52() {
        Max max = new Max();
        int result = max.max(10, 15, 35, 52);
        assertThat(result, is(52));
    }
}