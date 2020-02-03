package ru.job4j.generic;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {

    private AbstractStore<User> array = new UserStore(3);
    User user1 = new User("Max");
    User user2 = new User("Bob");
    User user3 = new User("Gim");
    User user4 = new User("Pop");

    @Test
    public void checkingMethodThatAddsUserStore() {
        array.add(user1);
        assertThat(array.findById("Max").getId(), is("Max"));
    }

    @Test
    public void checkingMethodThatFindUserStoreById() {
        array.add(user1);
        array.add(user2);
        array.add(user3);
        assertThat(array.findById("Bob"), is(user2));
    }

    @Test
    public void checkingMethodThatRemoveUserStoreById() {
        array.add(user1);
        array.add(user2);
        array.add(user3);
        assertThat(array.delete("Max"), is(true));
    }

    @Test
    public void checkingMethodOverwritesUserStoreById() {
        array.add(user1);
        array.add(user2);
        array.add(user3);
        assertThat(array.replace("Max", user4), is(true));
        assertThat(array.findById("Pop"), is(user4));
    }
}