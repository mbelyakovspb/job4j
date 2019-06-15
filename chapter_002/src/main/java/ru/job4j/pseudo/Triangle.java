package ru.job4j.pseudo;
/**
 * Класс Triangle
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 14.06.2019
 * @version 1
 */
public class Triangle implements Shape {
    /**
     * Метод реализаущий интерфейс Shape и создающий фигуру - треугольник
     * @return фигура - треугольник в псевдографике
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("    ^    " + '\n');
        pic.append("   ^^^   " + '\n');
        pic.append("  ^^^^^  " + '\n');
        pic.append(" ^^^^^^^ " + '\n');
        pic.append("^^^^^^^^^");
        return pic.toString();
    }
}
