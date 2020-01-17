package ru.job4j.iterator;

import java.util.Iterator;
/**
 * Класс ArrayIteratorTest
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 18.09.2020
 * @version 1
 */
public class ArrayIterator implements Iterator {
    private int[][] array;
    private int lineArray = 0;
    private int columnArray = 0;

    public ArrayIterator(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return lineArray < array.length;
    }

    @Override
    public Object next() {
        Object result = array[lineArray][columnArray++];
        if (array[lineArray].length <= columnArray) {
            lineArray++;
            columnArray = 0;
        }
        return result;
    }
}
