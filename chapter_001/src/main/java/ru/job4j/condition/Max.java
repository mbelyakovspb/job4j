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
    /**
     * Метод возвращает максимальное число из трех
     * @param first - первое число, second - второе число, third - третье число
     * @return максимальное из трех чисел
     */
    public int max(int first, int second, int third) {
        return max(first, second) >= third ? max(first, second) : third;
    }
    /**
     * Метод возвращает максимальное число из четырех
     * @param first - первое число, second - второе число, third - третье число, fourth - четвертое число
     * @return максимальное из четырех чисел
     */
    public int max(int first, int second, int third, int fourth) {
        return max(first, second, third) >= fourth ? max(first, second, fourth) : fourth;
    }
}