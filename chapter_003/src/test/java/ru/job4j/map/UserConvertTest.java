package ru.job4j.map;

import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserConvertTest {

    @Test
    public void whenListConvertToMapCheckForCity() {
        UserConvert userConvert = new UserConvert();
        List<User> input = List.of(
                new User(1, "Bob", "Washington"),
                new User(2, "Jon", "Chicago")
        );
        HashMap<Integer, User> result = userConvert.process(input);
        assertThat(result.get(1).getCity(), is("Washington"));
    }

    @Test
    public void whenListConvertToMapCheckForName() {
        UserConvert userConvert = new UserConvert();
        List<User> input = List.of(
                new User(1, "Bob", "Washington"),
                new User(2, "Jon", "Chicago")
        );
        HashMap<Integer, User> result = userConvert.process(input);
        assertThat(result.get(2).getName(), is("Jon"));
    }
}