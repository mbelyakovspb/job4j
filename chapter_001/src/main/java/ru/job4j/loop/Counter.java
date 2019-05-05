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
        int summ = 0;
        for (int in = start; in <= finish; in++) {
            if (in % 2 == 0 && in != 0) {
                summ += in;
            }
        }
        return summ;
    }
}
