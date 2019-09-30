package ru.job4j.stream;
/**
 * Класс Profile
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 29.09.2019
 * @version 1
 */
public class Profile {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public Profile(Address address) {
        this.address = address;
    }
}
