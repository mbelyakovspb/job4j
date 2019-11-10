package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {

    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (var number : this.persons) {
            if (number.getName().contains(key) || number.getAddress().contains(key)
                    || number.getSurname().contains(key) || number.getPhone().contains(key)) {
                result.add(number);
            }
        }
        return result;
    }
}