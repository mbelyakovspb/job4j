package ru.job4j.banktransfers;

import java.util.Objects;
/**
 * Класс User
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 19.08.2019
 * @version 1
 */
public class User implements Comparable<User> {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getPassport() {
        return this.passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }


    @Override
    public int compareTo(User o) {
        return this.getPassport().compareTo(o.getPassport());
    }
}
