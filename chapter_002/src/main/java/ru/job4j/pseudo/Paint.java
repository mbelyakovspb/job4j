package ru.job4j.pseudo;
/**
 * Класс Paint
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 14.06.2019
 * @version 1
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Square square = new Square();
        System.out.println(triangle.draw());
        System.out.println(square.draw());
    }
}
