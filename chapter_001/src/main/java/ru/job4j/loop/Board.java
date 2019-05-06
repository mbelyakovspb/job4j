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
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
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
