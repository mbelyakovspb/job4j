package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TurnTest {

    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] result = new int[]{1, 2, 3, 4};
        int[] massiv = new int[] {4, 3, 2, 1};
        int[] expect = turn.back(result);
        assertThat(massiv, is(expect));
    }
}