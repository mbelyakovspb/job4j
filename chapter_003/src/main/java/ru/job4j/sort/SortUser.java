package ru.job4j.sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Класс SortUser
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 14.08.2019
 * @version 1
 */
public class SortUser {
    /**
     * Метод сортирует список list по возрастанию поля age класса User
     * @param list лист, состоящий из объектов User
     * @return метод возвращает отсортированный list в виде множества Set
     */
    public Set<User> sortUser(List<User> list) {
        return list.stream().sorted(Comparator.comparingInt(User::getAge))
                .flatMap(Stream::ofNullable).collect(Collectors.toSet());
    }
    /**
     * Метод сортирует лист по длине символов поля name в классе User
     * @param list лист, состоящий из объектов User
     * @return метод возвращает отсортированный list в виде листа List
     */
    public List<User> sortByNameLengths(List<User> list) {
        return list.stream().sorted(Comparator.comparingInt(o -> o.getName().length()))
                .collect(Collectors.toList());

    }
    /**
     * Метод сортирует лист сперва по имени, а затем по возрастанию поля age класса User
     * @param list лист, состоящий из объектов User
     * @return метод возвращает отсортированный list в виде листа List
     */
    public List<User> sortByAllFields(List<User> list) {
        return list.stream().sorted(Comparator.comparing(User::getName)
                .thenComparingInt(User::getAge)).collect(Collectors.toList());
    }
}
