package ru.job4j.loop;
/**
 * Класс Factorial
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 05.05.2019
 * @version 1
 */
public class Factorial {
    /**
     * Метод вычисляет факториал от заданного числа
     * @param number - целое число
     * @return факториал числа
     */
    public int calc(int number) {
        int fact = 1;
        for (int input = 1; input <= number; input++) {
            fact *= input;
        }
        return fact;
    }
}
