package ru.job4j.iterator;

import java.util.*;
/**
 * Класс EvenIterator
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 20.01.2020
 * @version 1
 */
public class Converter {
    /**
     * Метод возвращает итератор чисел
     * @param iterator - список студентов
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> iterator) {
        return new Iterator<>() {
            Iterator<Integer> integerIterator = (new ArrayList<Integer>()).iterator();
            @Override
            public boolean hasNext() {
                while (iterator.hasNext() && !integerIterator.hasNext()) {
                    integerIterator = iterator.next();
                }
                return integerIterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return integerIterator.next();
            }
        };
    }
}
