package ru.job4j.array;
/**
 * Класс Square
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 08.05.2019
 * @version 1
 */
public class Square {
    /**
     * Метод заполняет массив числами, возведенными в квадрат
     * @param bound - размер массива
     * @return строку
     */
    public int[] calculate(int bound) {
        int[] number = new int[bound];
        for (int i = 0; i < bound; i++) {
            number[i] = (i + 1) * (i + 1);
        }
        return number;
    }
}
