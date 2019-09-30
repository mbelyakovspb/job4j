package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        Address address1 = new Address("Москва", "Мышинная", 13, 103);
        Address address2 = new Address("Ростов-на-Дону", "Ростовская", 23, 203);
        Address address3 = new Address("Севастополь", "Севастопольская", 33, 303);
        List<Profile> profiles = List.of(
                new Profile(address1),
                new Profile(address2),
                new Profile(address3)
        );
        List<Address> result = new Profiles().collect(profiles);
        List<Address> expected = List.of(
                address1, address3, address2
        );
        assertThat(result, is(expected));
    }
}