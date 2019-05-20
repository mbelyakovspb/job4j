package ru.job4j.loop;
/**
 * Класс Chess board
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 07.05.2019
 * @version 1
 */
public class Board {
    /**
     * Метод выводит крестики в консоли в шахматном порядке
     * @param width - длина доски
     * @param height - высота доски
     * @return строка из X в шахматном порядке
     */
    public String paint(int width, int height) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int out = 0; out < height; out++) {
            for (int in = 0; in < width; in++) {
                if ((out + in) % 2 == 0) {
                    stringBuilder.append("X");
                } else {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
