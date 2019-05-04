package ru.job4j.condition;
/**
 * Класс MultiMax
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 04.05.2019
 * @version 1
 */
public class MultiMax {
    /**
     * Метод находит наибольшее из трех чисел
     * @param first первое число
     * @param second второе число
     * @param third третье число
     * @return наибольшее из трех чисел
     */
    public int maxMulti(int first, int second, int third) {
        int result = (first >= second ? first : second);
        return result >= third ? result : third;
    }
}
