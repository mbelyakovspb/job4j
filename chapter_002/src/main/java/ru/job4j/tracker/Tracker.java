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
    private List<Item> items = new ArrayList<>();
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
        this.items.add(item);
        return item;
    }
    /**
     * Метод реализаущий изменение заявки в хранилище
     * @param id уникальный номер заявки
     * @param item изменения в заявке
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        int number = 0;
        for (Item count : this.items) {
            if (count.getId().equals(id)) {
                this.items.set(number, item);
                result = true;
                break;
            }
            number++;
        }
        return result;
    }
    /**
     * Метод реализаущий удаление заявки из хранилища
     * @param id уникальный номер заявки
     */
    public boolean delete(String id) {
        boolean result = false;
        int number = 0;
        for (Item count : this.items) {
            if (count.getId().equals(id)) {
                this.items.remove(number);
                result = true;
                break;
            }
            number++;
        }
        return result;
    }
    /**
     * Метод реализаущий поиск всех существующих заявок в хранилище
     */
    public List<Item> findAll() {
        return this.items.subList(0, this.items.size());
    }
    /**
     * Метод реализаущий поиск заявки в хранилище по имени заявки
     * @param name имя заявки
     */
    public List<Item> findByName(String name) {
        List<Item> arrays = new ArrayList<>();
        for (Item count : this.items) {
            if (count.getName().equals(name)) {
                arrays.add(count);
            }
        }
        return arrays;
    }
    /**
     * Метод реализаущий поиск заявки в хранилище по имени уникальному номеру
     * @param id уникальный номер заявки
     */
    public Item findById(String id) {
        Item result = null;
        for (Item count : this.items) {
            if (count.getId().equals(id)) {
                result = count;
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
