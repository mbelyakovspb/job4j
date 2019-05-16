package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixCheckTest {

    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, false, true},
                {true, true, false},
                {true, false, true}
        };
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(true));
    }
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, true, false},
                {true, false, true}
        };
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(false));
    }
    @Test
    public void whenDataMonoByTrueThenTrue4() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false, true},
                {false, true, true, true},
                {true, true, true, true},
                {true, false, true, true}
        };
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(true));
    }
    @Test
    public void whenDataNotMonoByTrueThenFalse4() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false, true},
                {false, true, true, true},
                {true, false, true, true},
                {true, false, true, true}
        };
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(false));
    }
}