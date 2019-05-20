package ru.job4j.array;
/**
 * Класс Matrix
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 11.05.2019
 * @version 1
 */
public class Matrix {
    /**
     * Метод перемножает между собой элементы двумерного массива
     * @param size - размер двумерного массив
     * @return возвращает перемноженные между собой элементы двумерного массива
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int out = 0; out < table.length; out++) {
            for (int in = 0; in < table.length; in++) {
                table[out][in] = (out + 1) * (in + 1);
            }
        }
        return table;
    }
}
