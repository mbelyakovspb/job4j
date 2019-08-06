package ru.job4j.map;

import java.util.HashMap;
import java.util.List;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User counter : list) {
            map.put(counter.getId(), counter);
        }
        return map;
    }
}
