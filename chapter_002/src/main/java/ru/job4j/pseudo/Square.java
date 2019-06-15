package ru.job4j.pseudo;
/**
 * Класс Square
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 14.06.2019
 * @version 1
 */
public class Square implements Shape {
    /**
     * Метод реализаущий интерфейс Shape и создающий фигуру - квадрат
     * @return фигура - квадрат в псевдографике
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+++++++++" + '\n');
        pic.append("+       +" + '\n');
        pic.append("+       +" + '\n');
        pic.append("+       +" + '\n');
        pic.append("+++++++++");
        return pic.toString();
    }
}
