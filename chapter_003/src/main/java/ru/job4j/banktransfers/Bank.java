package ru.job4j.banktransfers;

import java.util.*;
import java.util.stream.Collectors;
/**
 * Класс Bank
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 19.08.2019
 * @version 1
 */
public class Bank {
    private final Map<User, List<Account>> map = new TreeMap<>();

    public Map<User, List<Account>> getMap() {
        return map;
    }
    /**
     * Метод добавляет пользователя в коллекцию map
     * @param user типа User
     */
    public void addUser(User user) {
        this.map.put(user, new ArrayList<>());
    }
    /**
     * Метод удаляет пользователя из коллекции map
     * @param user типа User
     */
    public void deleteUser(User user) {
        this.map.remove(user);
    }
    /**
     * Метод добавляет аккаунт пользователя
     * @param passport - данные паспорта пользователя типа String, account - данные создаваемого аккаунта пользователя
     */
    public void addAccountToUser(String passport, Account account) {
        if (!this.map.isEmpty()) {
            this.map.entrySet().stream().filter(
                    userListEntry -> userListEntry.getKey().getPassport().equals(passport))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            userListEntry -> userListEntry.getValue().add(account)
                    ));
        }
    }
    /**
     * Метод удаляет аккаунт пользователя
     * @param passport - данные паспорта пользователя типа String, account - данные аккаунта пользователя
     */
    public void deleteAccountFromUser(String passport, Account account) {
        if (!this.map.isEmpty()) {
            this.map.entrySet().stream().filter(
                    userListEntry -> userListEntry.getKey().getPassport().equals(passport))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            userListEntry -> userListEntry.getValue().remove(account)
                    ));
        }
    }
    /**
     * Метод получает список аккаунта пользователя
     * @param passport - данные паспорта пользователя типа String
     */
    public List<Account> getUserAccount(String passport) {
        List<Account> accountList = new ArrayList<>();
        if (!this.map.isEmpty()) {
            accountList = this.map.entrySet().stream()
                    .filter(userListEntry -> userListEntry.getKey().getPassport().equals(passport))
                    .map(Map.Entry::getValue).collect(Collectors.toList()).get(0);
        }
        return accountList;
    }
    /**
     * Метод для перечисления денежной сумму от одного пользователя другому
     * @param srcPassport - данные паспорта пользователя типа String, от которого переводим денежную сумму
     * @param  srcRequisite - номер счета пользователя типа String, от которого переводим денежную сумму
     * @param desPassport - данные паспорта пользователя типа String, которому переводим денежную сумму
     * @param desRequisite - номер счета пользователя типа String, которому переводим денежную сумму
     * @param amount - сумма перевода типа double
     * @return - возвращает true, если деньги переведены
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String desPassport, String desRequisite, double amount) {
        boolean result = false;
        Account oneAccount = accountSearchByDetails(srcPassport, srcRequisite);
        Account twoAccount = accountSearchByDetails(desPassport, desRequisite);
        if (oneAccount != null && twoAccount != null) {
            if (oneAccount.getValue() >= amount) {
                oneAccount.setValue(oneAccount.getValue() - amount);
                twoAccount.setValue(twoAccount.getValue() + amount);
                result = true;
            }
        }
        return result;
    }
    /**
     * Метод осуществляет поиск аккаунта пользователя по passport и по requisite
     * @param passport - паспорт пользователя, requisite - реквизиты счета
     * @return метод возвращает найденный в Map аккаунт пользователя
     */
    public Account accountSearchByDetails(String passport, String requisite) {
        List<Account> list = getUserAccount(passport);
        return list.stream()
                .filter(account -> account.getRequisites().equals(requisite))
                .findFirst().orElse(null);
    }
}

