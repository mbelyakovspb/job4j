package ru.job4j.generic;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    private AbstractStore<Role> array = new RoleStore(3);
    Role role1 = new Role("Max");
    Role role2 = new Role("Bob");
    Role role3 = new Role("Gim");
    Role role4 = new Role("Pop");

    @Test
    public void checkingMethodThatAddsRoleStore() {
        array.add(role1);
        assertThat(array.findById("Max").getId(), is("Max"));
    }

    @Test
    public void checkingMethodThatFindUserRoleById() {
        array.add(role1);
        array.add(role2);
        array.add(role3);
        assertThat(array.findById("Bob"), is(role2));
    }

    @Test
    public void checkingMethodThatRemoveUserRoleById() {
        array.add(role1);
        array.add(role2);
        array.add(role3);
        assertThat(array.delete("Max"), is(true));
    }

    @Test
    public void checkingMethodOverwritesUserRoleById() {
        array.add(role1);
        array.add(role2);
        array.add(role3);
        assertThat(array.replace("Max", role4), is(true));
        assertThat(array.findById("Pop"), is(role4));
    }
}