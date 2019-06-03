package ru.job4j.condition;

import static java.lang.Math.*;
/**
 * Класс Point
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 02.05.2019
 * @version 1
 */
public class Point {
    /**
     * Это поле объекта. Оно доступно только конкретному объекту.
     */
    private int x;
    /**
     * Это поле объекта. Оно доступно только конкретному объекту.
     */
    private int y;
    /**
     * Это поле объекта. Оно доступно только конкретному объекту.
     */
    private int z;
    /**
     * Конструктор, который принимает начальное состояние объекта "точка"
     * @param first координата x
     * @param second координата y
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }
    /**
     * Конструктор, который принимает начальное состояние объекта "точка"
     * @param first координата x
     * @param second координата y
     * @param third координата z
     */
    public Point(int first, int second, int third) {
        this.x = first;
        this.y = second;
        this.z = third;
    }
    /**
     * Метод distance вычисляет расстояния между точками
     * @param that - координаты точки на графике
     * @return расстояние между точками
     */
    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }
    /**
     * Метод distance3d вычисляет расстояния между точками в трехмерном пространстве
     * @param that - координаты точки на графике
     * @return расстояние между точками
     */
    public double distance3d(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2) + pow(this.z - that.z, 2));
    }
    /**
     * Метод info выводит на экран координаты 2 точек
     */
    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
    /**
     * Метод info3d выводит на экран координаты 3 точек
     */
    public void info3d() {
        System.out.println(String.format("Point[%s, %s, %s]", this.x, this.y, this.z));
    }
}
