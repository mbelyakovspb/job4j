package ru.job4j.loop;
/**
 * Класс Paint
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 07.05.2019
 * @version 1
 */
public class Paint {
    /**
     * Метод рисует левую часть пирамиды в консоли
     * @param height - высота пирамиды
     * @return строку
     */
    public String leftTriangle(int height) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != height; column++) {
                if (row >= column) {
                    stringBuilder.append("^");
                } else {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
    /**
     * Метод рисует правую часть пирамиды в консоли
     * @param height - высота пирамиды
     * @return строку
     */
    public String rightTriangle(int height) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != height; column++) {
                if (row >= height - column - 1) {
                    stringBuilder.append("^");
                } else {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
    /**
     * Метод рисует пирамиду в консоли
     * @param height - высота пирамиды
     * @return строку
     */
    public String triangle(int height) {
        StringBuilder stringBuilder = new StringBuilder();
        int width = height * 2 - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
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
