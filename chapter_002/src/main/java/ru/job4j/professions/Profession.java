package ru.job4j.professions;
/**
 * Класс Profession
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 04.06.2019
 * @version 1
 */
public class Profession {
    /**
     * Это поле имя.
     */
    String name;
    /**
     * Это поле фамилия.
     */
    String surname;
    /**
     * Это поле образование.
     */
    String education;
    /**
     * Это поле дата рождения.
     */
    int birthday;
    /**
     * Это поле возраст.
     */
    int age;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public int getBirthday() {
        return birthday;
    }

    public int getAge() {
        return age;
    }
}
