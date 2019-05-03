package ru.job4j.condition;
/**
 * Класс Max
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 03.05.2019
 * @version 1
 */
public class Max {
    /**
     * Метод возвращает максимальное число из двух
     * @param left - первое число, right - второе число
     * @return максимальное из двух чисел
     */
    public int max(int left, int right) {
        return left >= right ? left : right;
    }
}
