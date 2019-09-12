package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionRangeTest {

    @Test
    public void whenLinearFunctionOnetoFour() {
        FunctionRange functionRange = new FunctionRange();
        List<Double> expected = Arrays.asList(1D, 2D, 3D);
        List<Double> result = functionRange.diapason(
                1, 4, x -> x
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionOnetoFour() {
        FunctionRange functionRange = new FunctionRange();
        List<Double> expected = Arrays.asList(1D, 4D, 9D);
        List<Double> result = functionRange.diapason(
                1, 4, x -> x * x
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionOnetoFour() {
        FunctionRange functionRange = new FunctionRange();
        List<Double> expected = Arrays.asList(0.0D, 0.6931471805599453D, 1.0986122886681098D);
        List<Double> result = functionRange.diapason(
                1, 4, Math::log
        );
        assertThat(result, is(expected));
    }
}