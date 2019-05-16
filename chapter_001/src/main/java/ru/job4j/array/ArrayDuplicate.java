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
        for (int i = 0; i < unique; i++) {
            for (int j = i + 1; j < unique; j++) {
                if (array[i].equals(array[j])) {
                    array[i] = array[unique - 1];
                    unique--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
