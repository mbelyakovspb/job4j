package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс ConvertList2Array
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 30.07.2019
 * @version 1
 */
public class ConvertList2Array {
    /**
     * Метод разбивает лист на количество строк двумерного массива
     * @param list состоящий из целых чисел
     * @param rows количество строк в двумерном массиве
     * @return метод возвращает двумерный массив с количеством строк rows
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;
        if (list.size() % rows != 0) {
            cells++;
        }
        int[][] array = new int[rows][cells];
        int indexOfNum = 0;
        int counter = 0;
        for (Integer listObj : list) {
            array[indexOfNum][counter++] = listObj;
            if (counter == cells) {
                counter = 0;
                indexOfNum++;
            }
        }
        return array;
    }
    /**
     * Метод конвертирует лист массивов в один лист Integer
     * @param list состоящий из массивов целых чисел
     * @return метод возвращает лист Integer
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> array = new ArrayList<>();
        for (int[] numb : list) {
            for (int cout : numb) {
                array.add(cout);
            }
        }
        return array;
    }
}
