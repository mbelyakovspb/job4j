package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Класс EvenIterator
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 18.09.2020
 * @version 1
 */
public class EvenIterator implements Iterator {
    private final int[] arrays;
    private int position;

    public EvenIterator(int[] arrays) {
        this.arrays = arrays;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int index = position; index < arrays.length; index++) {
            if (arrays[index] % 2 == 0) {
                position = index;
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return arrays[position++];
    }
}
