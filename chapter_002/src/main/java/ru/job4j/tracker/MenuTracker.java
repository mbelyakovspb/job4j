package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Класс MenuTracker
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 16.06.2019
 * @version 1
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private Consumer<String> output;

    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void fillActions() {
        System.out.println("Меню");
        this.actions.add(this.new AddItem(0, "Добавление новой заявки."));
        this.actions.add(this.new ShowAllItem(1, "Показать все заявки."));
        this.actions.add(this.new EditItem(2, "Редактировать заявку."));
        this.actions.add(this.new DeleteItem(3, "Удалить заявку."));
        this.actions.add(this.new FindItemById(4, "Найти заявку по id."));
        this.actions.add(this.new FindItemByName(5, "Найти заявку по имени."));
    }

    public int[] getActionsLength() {
        int[] range = new int[this.actions.size()];
        for (int index = 0; index < range.length; index++) {
            range[index] = index;
        }
        return range;
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }
    /**
     * Класс реализует добавление новой заявки
     */
    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("---------- Добавление новой заявки ----------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept("---------- Новая заявка с getId : " + item.getId() + "----------");
        }
    }
    /**
     * Класс реализует вывод всех существующих заявок
     */
    private class ShowAllItem extends BaseAction {

        public ShowAllItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("---------- Начало списка всех заявок ----------");
            for (Item item : tracker.findAll()) {
                System.out.println(item.toString());
            }
            output.accept("---------- Конец списка всех заявок ----------");
        }
    }
    /**
     * Класс реализует редактирование заявок
     */
    private class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("---------- Редактирование заявки ----------");
            String id = input.ask("Введите id заявки : ");
            if (tracker.findById(id) != null) {
                String name = input.ask("Внесите изменения в имя заявки : ");
                String desc = input.ask("Внесите изменения в описание заявки : ");
                tracker.replace(id, new Item(name, desc));
                output.accept("---------- Изменения внесены успешно ----------");
            } else {
                output.accept("---------- Заявки с таким Id не существует ----------");
            }
        }
    }
    /**
     * Класс реализует удаление заявок
     */
    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("---------- Удаление заявки ----------");
            String id = input.ask("Введите id заявки : ");
            tracker.delete(id);
            output.accept("---------- Заявка успешно удалена ----------");
        }
    }
    /**
     * Класс реализует поиск заявок по id
     */
    private class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("---------- Поиск заявки по id ----------");
            String id = input.ask("Введите id заявки : ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item.toString());
            } else {
                output.accept("---------- Заявки с таким Id не существует ----------");
            }
        }
    }
    /**
     * Класс реализует поиск заявок по имени
     */
    private class FindItemByName extends BaseAction {

        public FindItemByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("---------- Поиск заявки по имени ----------");
            String name = input.ask("Введите имя заявки : ");
            for (Item item : tracker.findByName(name)) {
                System.out.println(item.toString());
            }
        }
    }
}
