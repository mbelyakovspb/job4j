package ru.job4j.condition;
/**
 * Класс Triangle
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 04.05.2019
 * @version 1
 */
@SuppressWarnings("ALL")
public class Triangle {
    /**
     * Это поле объекта. Доступно только конкретному объекту
     */
    private Point first;
    /**
     * Это поле объекта. Доступно только конкретному объекту
     */
    private Point second;
    /**
     * Это поле объекта. Доступно только конкретному объекту
     */
    private Point third;
    /**
     * Конструктор, который принимает начальное состояние объекта "вершина треугольника"
     * @param first - первая вершина треугольника
     * @param second - вторая вершина треугольника
     * @param third - третья вершина треугольника
     */
    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }
    /**
     * Метод вычисляет периметр по длинам сторон
     * @param a расстояние между a и b
     * @param b расстояние между a и c
     * @param c расстояние между b и c
     * @return Периметр треугольника
     */
    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }
    /**
     * Метод вычисляет площадь треугольника
     * @param first первая вершина треугольника
     * @param second вторая вершина треугольника
     * @param third третья вершина треугольника
     * @return result величину площади треугольника
     */
    public double area(Point first, Point second, Point third) {
        double result = -1;
        double a = first.distance(second);
        double b = second.distance(third);
        double c = third.distance(first);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return result;
    }
    /**
     * Метод проверяет возможность существования треугольника
     * @param a расстояние между a и b
     * @param b расстояние между a и c
     * @param c расстояние между b и c
     * @return true, если треугольник со сторонами a,b,c существует
     */
    public boolean exist(double a, double c, double b) {
        return ((a + b) > c && (b + c) >  a && (a + c) > b);
    }
}
