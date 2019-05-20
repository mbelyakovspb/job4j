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
        for (int input = 0; input < bound; input++) {
            number[input] = (input + 1) * (input + 1);
        }
        return number;
    }
}
