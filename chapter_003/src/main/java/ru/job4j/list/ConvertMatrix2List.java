package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс ConvertMatrix2List
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 02.08.2019
 * @version 1
 */
public class ConvertMatrix2List {
    /**
     * Метод преобразовывает двумерный массив в список
     * @param array-двумерный массив, состоящий из целых чисел
     * @return метод возвращает список ArrayList
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] index : array) {
            for (int counterOfArray : index) {
                list.add(counterOfArray);
            }
        }
        return list;
    }
}
