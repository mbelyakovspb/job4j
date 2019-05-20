package ru.job4j.array;
/**
 * Класс Turn
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 09.05.2019
 * @version 1
 */
public class Turn {
    /**
     * Метод переворачивает массив заданом наперед
     * @param array - массива целых чисел
     * @return перевернутый массив
     */
    public int[] back(int[] array) {
        for (int input = 0; input < array.length / 2; input++) {
            int number = array[input];
            array[input] = array[array.length - input - 1];
            array[array.length - input - 1] = number;
        }
        return array;
    }
}
