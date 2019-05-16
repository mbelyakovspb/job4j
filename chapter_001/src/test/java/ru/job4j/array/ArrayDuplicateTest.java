package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.*;

public class ArrayDuplicateTest {

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = new String[]{"Вова", "Гриша", "Петя", "Вова", "Влад"};
        String[] result = new String[]{"Вова", "Гриша", "Петя", "Влад"};
        String[] expected = arrayDuplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expected));
    }
}