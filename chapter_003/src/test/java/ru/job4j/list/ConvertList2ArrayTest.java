package ru.job4j.list;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expected = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expected));
    }

    @Test
    public void whenListOf3ArraysOf1ThenReturnsListOf8Elements() {
        ConvertList2Array converter = new ConvertList2Array();
        List<int[]> input = List.of(
                new int[] {1, 2, 3},
                new int[] {4, 5, 6},
                new int[] {7, 8}
        );
        List<Integer> result = converter.convert(input);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(result, is(expected));
    }
}