package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * Класс StartUI
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 12.06.2019
 * @version 1
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Функциональный интерфейс для реализации шаблона Стратегия.
     */
    private final Consumer<String> output;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     * @param output поле, реализующее функциональный интерфейс.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }
    /**
     * Основной цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Введите пункт меню: ", menu.getActionsLength()));
        } while (!"y".equals(this.input.ask("Выйти? (y): ")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}
