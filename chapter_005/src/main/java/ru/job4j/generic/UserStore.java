package ru.job4j.generic;
/**
 * Класс UserStore
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 02.02.2020
 * @version 1
 */
public class UserStore extends AbstractStore<User> {
    public UserStore(int size) {
        super(size);
    }
}
