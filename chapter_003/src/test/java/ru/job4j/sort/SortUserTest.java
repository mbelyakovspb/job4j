package ru.job4j.sort;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {

    @Test
    public void whenListSortedByAscendingKey() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Petya"));
        list.add(new User(5, "Vasya"));
        list.add(new User(2, "Jora"));
        list.add(new User(0, "Jonik"));
        Set<User> expected = Set.of(
                new User(0, "Jonik"),
                new User(1, "Petya"),
                new User(2, "Jora"),
                new User(5, "Vasya")
        );
        Set<User> result = new SortUser().sortUser(list);
        assertThat(result, is(expected));
    }

    @Test
    public void whenListSortedByNameLength() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Boberchik"));
        list.add(new User(5, "Vasilek"));
        list.add(new User(2, "Bond"));
        list.add(new User(20, "Kok"));
        list.add(new User(0, "Kukelbeker"));
        List<User> expected = List.of(
                new User(20, "Kok"),
                new User(2, "Bond"),
                new User(5, "Vasilek"),
                new User(1, "Boberchik"),
                new User(0, "Kukelbeker")
        );
        List<User> result = new SortUser().sortByNameLengths(list);
        assertThat(result, is(expected));
    }

    @Test
    public void whenListSortedByNameAndAge() {
        List<User> list = new ArrayList<>();
        list.add(new User(25, "Сергей"));
        list.add(new User(30, "Иван"));
        list.add(new User(20, "Сергей"));
        list.add(new User(25, "Иван"));
        List<User> expected = List.of(
                new User(25, "Иван"),
                new User(30, "Иван"),
                new User(20, "Сергей"),
                new User(25, "Сергей")
        );
        List<User> result = new SortUser().sortByAllFields(list);
        assertThat(result, is(expected));
    }
}