package ru.job4j.sort;

import java.util.*;
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
        Set<User> set = new TreeSet<>();
        Collections.sort(list);
        set.addAll(list);
        return set;
    }
    /**
     * Метод сортирует лист по длине символов поля name в классе User
     * @param list лист, состоящий из объектов User
     * @return метод возвращает отсортированный list в виде листа List
     */
    public List<User> sortByNameLengths(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return list;
    }
    /**
     * Метод сортирует лист сперва по имени, а затем по возрастанию поля age класса User
     * @param list лист, состоящий из объектов User
     * @return метод возвращает отсортированный list в виде листа List
     */
    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getName().compareTo(o2.getName());
                return result != 0 ? result : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
    }
}
