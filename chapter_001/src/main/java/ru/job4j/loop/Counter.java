package ru.job4j.loop;
/**
 * Класс Counter
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 05.05.2019
 * @version 1
 */
public class Counter {
    /**
     * Метод подсчитывает сумму четных чисел в заданном диапазоне
     * @param start - начальный элемент диапазона целых чисел
     * @param finish - конечное значение диапазона целых чисел
     * @return сумма четных чисел
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int input = start; input <= finish; input++) {
            if (input % 2 == 0 && input != 0) {
                sum += input;
            }
        }
        return sum;
    }
}
