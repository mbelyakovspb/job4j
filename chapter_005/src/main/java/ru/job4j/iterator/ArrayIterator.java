package ru.job4j.iterator;

import java.util.Iterator;
/**
 * Класс ArrayIteratorTest
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 18.01.2020
 * @version 1
 */
public class ArrayIterator implements Iterator {
    private final int[][] array;
    private int line = 0;
    private int column = 0;

    public ArrayIterator(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return line < array.length;
    }

    @Override
    public Object next() {
        Object result = array[line][column++];
        if (array[line].length <= column) {
            line++;
            column = 0;
        }
        return result;
    }
}
