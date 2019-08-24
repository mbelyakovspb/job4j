package ru.job4j.banktransfers;

import java.util.Objects;
/**
 * Класс Account
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 19.08.2019
 * @version 1
 */
public class Account {
    private String requisite;
    private double value;

    public Account(String requisites, double value) {
        this.requisite = requisites;
        this.value = value;
    }

    public String getRequisites() {
        return this.requisite;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Double.compare(account.value, value) == 0
                && Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite, value);
    }
}
