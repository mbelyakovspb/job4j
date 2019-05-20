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
        for (int input = 0; input < data.length - 1; input++) {
            if ((data[input][input] != data[input + 1][input + 1])
                    || data[0][data.length - 1] != data[input][data.length - input - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
