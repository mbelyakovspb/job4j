package ru.job4j.array;
/**
 * Класс BubbleSort
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 11.05.2019
 * @version 1
 */
public class BubbleSort {
    /**
     * Метод проверяет что слово начинается с префикса
     * @param array - сортируемый массив
     * @return возвращает отсортироанный массив array
     */
    public int[] sort(int[] array) {
        for (int out = 0; out < array.length; out++) {
            for (int in = 0; in < array.length - out - 1; in++) {
                if (array[in] > array[in + 1]) {
                    int number = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = number;
                }
            }
        }
        return array;
    }
}
