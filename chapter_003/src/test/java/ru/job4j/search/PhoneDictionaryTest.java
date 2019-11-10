package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(new Person(
                "Максим", "Беляков", "8(812)300-008", "ул. Достоевского, дом 36"
        ));
        var personList = phones.find("ул");
        assertThat(personList.iterator().next().getSurname(), is("Беляков"));
    }
}