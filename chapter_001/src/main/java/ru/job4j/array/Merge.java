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
        for (int i = rsl.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (rsl[j] > rsl[j + 1]) {
                    int number = rsl[j];
                    rsl[j] = rsl[j + 1];
                    rsl[j + 1] = number;
                }
            }
        }
        return rsl;
    }
}
