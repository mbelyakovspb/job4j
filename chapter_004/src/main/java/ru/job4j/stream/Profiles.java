package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Класс Profiles
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 29.09.2019
 * @version 1
 */
public class Profiles {
    /**
     * Метод возвращает список учеников с балами, из заданных диапазонов
     * @param profiles - список анкет клиентов
     * @return - список адресов клиентов
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).distinct().sorted(
                Comparator.comparing(profile -> profile.getCity().length())).collect(Collectors.toList());
    }
}
