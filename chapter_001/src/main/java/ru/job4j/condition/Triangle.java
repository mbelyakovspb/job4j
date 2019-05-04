package ru.job4j.condition;
/**
 * Класс Triangle
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 04.05.2019
 * @version 1
 */
public class Triangle {
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
     * @param x1, y1 первая вершина треугольника
     * @param x2, y2 вторая вершина треугольника
     * @param x3, y3 третья вершина треугольника
     * @return result величину площади треугольника
     */
    public double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        double result = -1;
        double a = new Point().distance(x1, y1, x2, y2);
        double b = new Point().distance(x2, y2, x3, y3);
        double c = new Point().distance(x1, y1, x3, y3);
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
        return ((a + b) >= c || (b + c) >=  a || (a + c) >= b);
    }
}
