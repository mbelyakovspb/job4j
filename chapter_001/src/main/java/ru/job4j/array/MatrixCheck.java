package ru.job4j.array;
/**
 * Класс Matrix
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 11.05.2019
 * @version 1
 */
public class MatrixCheck {
    /**
     * Метод перемножает между собой элементы двумерного массива
     * @param data - размер двумерного массив
     * @return возвращает перемноженные между собой элементы двумерного массива
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if ((data[i][i] != data[i + 1][i + 1]) || data[0][data.length - 1] != data[i][data.length - i - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
