package ru.job4j.banktransfers;

import org.junit.Test;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void whenAddUserInMap() {
        Bank bank = new Bank();
        User user1 = new User("Max", "B88");
        User user2 = new User("Jon", "C99");
        bank.addUser(user1);
        bank.addUser(user2);
        assertThat(bank.getMap().keySet().size(), is(2));
    }

    @Test
    public void whenDeleteUserFromMap() {
        Bank bank = new Bank();
        User user1 = new User("Max", "B88");
        User user2 = new User("Jon", "C99");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.deleteUser(user2);
        assertThat(bank.getMap().keySet().size(), is(1));
    }

    @Test
    public void whenAddUserAccountInMap() {
        User user = new User("Max", "B88");
        Bank bank = new Bank();
        bank.addUser(user);
        bank.addAccountToUser("B88", new Account("Russian_666666", 1000));
        Map<User, List<Account>> map = bank.getMap();
        assertThat(map.get(user).get(0).getRequisites(), is("Russian_666666"));
    }

    @Test
    public void whenGetUserAccountFromMap() {
        User user = new User("Max", "B88");
        Bank bank = new Bank();
        bank.addUser(user);
        bank.addAccountToUser("B88", new Account("Russian_666666", 1000));
        bank.addAccountToUser("B88", new Account("English_666666", 2000));
        List<Account> list = bank.getUserAccount("B88");
        assertThat(list.get(1).getRequisites(), is("English_666666"));
    }

    @Test
    public void whenDeleteUserAccountFromMap() {
        User user = new User("Max", "B88");
        Bank bank = new Bank();
        bank.addUser(user);
        Account account = new Account("Russian_666666", 1000);
        bank.addAccountToUser("B88", account);
        bank.deleteAccountFromUser("B88", account);
        Map<User, List<Account>> map = bank.getMap();
        assertThat(map.get(user).size(), is(0));
    }

    @Test
    public void whenTransferMoneyFromAccountOfFirstUserToAccountOfSecond() {
        User userOne = new User("Max", "B88");
        User userTwo = new User("Vitya", "C99");
        Bank bank = new Bank();
        bank.addUser(userOne);
        bank.addUser(userTwo);
        bank.addAccountToUser("B88", new Account("France_555555", 1000));
        bank.addAccountToUser("C99", new Account("Russian_666666", 50));
        boolean result =  bank.transferMoney(
                "B88", "France_555555",
                "C99", "Russian_666666", 900);
        assertThat(result, is(true));
    }

    @Test
    public void whenToGetUserAccountByPassportAndRequisites() {
        User user = new User("Max", "B88");
        User user2 = new User("Vitya", "C99");
        Bank bank = new Bank();
        bank.addUser(user);
        bank.addUser(user2);
        bank.addAccountToUser("C99", new Account("France_555555", 100));
        bank.addAccountToUser("B88", new Account("Russian_666666", 1000));
        Account list = bank.accountSearchByDetails("C99", "France_555555");
        assertThat(list.getRequisites(), is("France_555555"));
    }
}