package ru.job4j.tracker;
/**
 * Класс MenuOutException
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 19.06.2019
 * @version 1
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String message) {
        super(message);
    }
}
