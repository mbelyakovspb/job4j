package ru.job4j.tracker;

import java.util.*;
/**
 * Класс Tracker
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 06.06.2019
 * @version 1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод реализаущий изменение заявки в хранилище
     * @param id уникальный номер заявки
     * @param item изменения в заявке
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index != position; index++) {
            if (items[index].getId().equals(id)) {
                items[index] = item;
                item.setId(id);
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Метод реализаущий удаление заявки из хранилища
     * @param id уникальный номер заявки
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index != position; index++) {
            if (items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, items, index, items.length - index - 1);
                result = true;
                position--;
                break;
            }
        }
        return result;
    }
    /**
     * Метод реализаущий поиск всех существующих заявок в хранилище
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, this.position);
    }
    /**
     * Метод реализаущий поиск заявки в хранилище по имени заявки
     * @param name имя заявки
     */
    public Item[] findByName(String name) {
        Item[] result = new Item[this.position];
        int counter = 0;
        for (int index = 0; index != position; index++) {
            if (items[index] != null && items[index].getName().equals(name)) {
                result[counter] = items[index];
                counter++;
            }
        }
        return Arrays.copyOf(result, counter);
    }
    /**
     * Метод реализаущий поиск заявки в хранилище по имени уникальному номеру
     * @param id уникальный номер заявки
     */
    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index != position; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                result = items[index];
                break;
            }
        }
        return result;
    }
    /**
     * Метод реализаущий генерацию уникального номера заявки
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() * ((new Random()).nextInt() + 1));
    }
}
