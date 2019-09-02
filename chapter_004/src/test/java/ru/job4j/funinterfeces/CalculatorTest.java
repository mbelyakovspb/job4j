package ru.job4j.funinterfeces;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void whenAddUntilThree() {
        Calculator calculator = new Calculator();
        List<Double> list = new ArrayList<>();
        calculator.multiple(
                0, 3, 1,
                (value, index) -> (double) value + index,
                list::add
                );
        assertThat(list, is(Arrays.asList(1D, 2D, 3D)));
    }
}