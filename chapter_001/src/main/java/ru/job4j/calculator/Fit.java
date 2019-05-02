package ru.job4j.calculator;
/**
 * Класс калькулятор идеального веса
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 02.05.2019
 * @version 1
 */
public class Fit {
    /**
     * Метод расчитывает идеальный вес мужчины в зависимости от роста
     * @param height рост мужчины
     * @return идеальный вес мужчины
     */
    public double manWeight(double height) {
        return Math.round(((height - 100) * 1.15) * 10d) / 10d;
    }
    /**
     * Метод расчитывает идеальный вес женщины в зависимости от роста
     * @param height рост женщины
     * @return идеальный вес женщины
     */
    public double womenWeight(double height) {
        return Math.round(((height - 110) * 1.15) * 10d) / 10d;
    }
}
