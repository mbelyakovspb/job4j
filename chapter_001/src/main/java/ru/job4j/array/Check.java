package ru.job4j.array;
/**
 * Класс Turn
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 10.05.2019
 * @version 1
 */
public class Check {
    /**
     * Метод проверяет что все элементы массива true или false
     * @param data - массива из значений true или false
     * @return логическое true или false
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int input = 0; input < data.length - 1; input++) {
            if (data[input] != data[input + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
