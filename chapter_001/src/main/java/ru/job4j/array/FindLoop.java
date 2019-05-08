package ru.job4j.array;
/**
 * Класс FindLoop
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 08.05.2019
 * @version 1
 */
public class FindLoop {
    /**
     * Метод для поиска индекса элемента в массиве
     * @param data - размер массива
     * @param element - элемент подлежащий поиску
     * @return индекс ячейки, в которой хранится element
     */
    public int indexOf(int[] data, int element) {
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == element) {
                index = i;
            }
        }
        return index;
    }
}
