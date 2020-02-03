package ru.job4j.generic;
/**
 * Интерфейс Store
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 02.02.2020
 * @version 1
 */
public interface Store<T extends Base> {
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
