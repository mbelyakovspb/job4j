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
     * @param massiv - массива целых чисел
     * @return перевернутый массив
     */
    public int[] back(int[] massiv) {
        for (int i = 0; i < massiv.length / 2; i++) {
            int number = massiv[i];
            massiv[i] = massiv[massiv.length - i - 1];
            massiv[massiv.length - i - 1] = number;
        }
        return massiv;
    }
}
