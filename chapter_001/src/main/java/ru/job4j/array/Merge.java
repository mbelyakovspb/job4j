package ru.job4j.array;
/**
 * Класс ArrayChar
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 18.05.2019
 * @version 1
 */
public class Merge {
    /**
     * Метод объединяет и сортирует два массива
     * @param left - первый массив, right - второй массив
     * @return возвращает отсортированный массив
     */
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        System.arraycopy(left, 0, rsl, 0, left.length);
        System.arraycopy(right, 0, rsl, left.length, right.length);
        for (int out = rsl.length - 1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                if (rsl[in] > rsl[in + 1]) {
                    int number = rsl[in];
                    rsl[in] = rsl[in + 1];
                    rsl[in + 1] = number;
                }
            }
        }
        return rsl;
    }
}
