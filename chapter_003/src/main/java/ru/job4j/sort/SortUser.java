package ru.job4j.sort;

import java.util.*;

public class SortUser {
    public Set<User> sortUser(List<User> list) {
        Set<User> set = new TreeSet<>();
        Collections.sort(list);
        set.addAll(list);
        return set;
    }
}
