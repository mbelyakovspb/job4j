package ru.job4j.sort;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {

    @Test
    public void whenListSortedInTreeSet() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Petya"));
        list.add(new User(5, "Vasya"));
        list.add(new User(2, "Jora"));
        list.add(new User(0, "Jonik"));
        List<User> expected = List.of(
                new User(0, "Jonik"),
                new User(1, "Petya"),
                new User(2, "Jora"),
                new User(5, "Vasya")
        );
        Set<User> result = new SortUser().sortUser(list);
        assertThat(result, is(expected));
    }
}