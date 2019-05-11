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
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - j - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int number = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = number;
                }
            }
        }
        return array;
    }
}
