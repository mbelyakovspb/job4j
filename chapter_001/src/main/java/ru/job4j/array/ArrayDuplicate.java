package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс ArrayChar
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 16.05.2019
 * @version 1
 */
public class ArrayDuplicate {
    /**
     * Метод удаляет дубликаты в массиве
     * @param array массив строк
     * @return массив с уникальными элементами
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[out] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
