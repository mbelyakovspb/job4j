package ru.job4j.condition;
/**
 * Класс Point
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 02.05.2019
 * @version 1
 */
public class Point {
    /**
     * Метод distance вычисляет расстояния между точками
     * @param x1, y1 - координаты точки на графике
     * @return расстояние между точками
     */
    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
