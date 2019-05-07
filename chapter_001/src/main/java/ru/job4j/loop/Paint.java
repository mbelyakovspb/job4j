package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Класс Paint
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 07.05.2019
 * @version 2
 */
public class Paint {
    /**
     * Метод рисует левую часть пирамиды в консоли
     * @param height - высота пирамиды
     * @return строку
     */
    public String leftTriangle(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }
    /**
     * Метод рисует правую часть пирамиды в консоли
     * @param height - высота пирамиды
     * @return строку
     */
    public String rightTriangle(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }
    /**
     * Метод рисует пирамиду в консоли
     * @param height - высота пирамиды
     * @return строку
     */
    public String triangle(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }
    private String loopBy(int height, int width, BiPredicate<Integer, Integer> predicate) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (predicate.test(row, column)) {
                    stringBuilder.append("^");
                } else {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
