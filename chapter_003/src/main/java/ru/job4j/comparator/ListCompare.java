package ru.job4j.comparator;

import java.util.Comparator;
/**
 * Класс ListCompare
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 15.08.2019
 * @version 1
 */
public class ListCompare implements Comparator<String> {
    /**
     * Метод сравнивает две строки на идентичность
     * @param o1, o2 строка String
     * @return метод возвращает целое положительное (отрицательное) число или ноль
     */
    @Override
    public int compare(String o1, String o2) {
        int size = Math.min(o1.length(), o2.length());
        int result = 0;
        for (int index = 0; index < size; index++) {
            result = Character.compare(o1.charAt(index), o2.charAt(index));
            if (result != 0) {
                break;
            }
        }
        return result == 0 ? Integer.compare(o1.length(), o2.length()) : result;
    }
}