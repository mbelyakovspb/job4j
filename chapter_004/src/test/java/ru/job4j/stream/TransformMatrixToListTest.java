package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransformMatrixToListTest {
    @Test
    public void whenTransformArraysToList() {
        Integer[][] matrix = new Integer[][] {{1, 2, 3}, {4, 5, 6}};
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        TransformMatrixToList matrixToList = new TransformMatrixToList();
        List<Integer> result = matrixToList.transform(matrix);
        assertThat(expected, is(result));

    }
}