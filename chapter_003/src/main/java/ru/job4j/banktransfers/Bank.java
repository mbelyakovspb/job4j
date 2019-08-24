package ru.job4j.banktransfers;

import java.util.*;
/**
 * Класс Bank
 * @author Maksim Belyakov (belyak1313@bk.ru)
 * @since 19.08.2019
 * @version 1
 */
public class Bank {
    private Map<User, List<Account>> map = new TreeMap<>();

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
        for (Map.Entry<User, List<Account>> key : this.map.entrySet()) {
            if (key.getKey().getPassport().equals(passport) && key.getKey().getPassport() != null) {
                List<Account> list = this.map.get(key.getKey());
                list.add(account);
                break;
            }
        }
    }
    /**
     * Метод удаляет аккаунт пользователя
     * @param passport - данные паспорта пользователя типа String, account - данные аккаунта пользователя
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> key : this.map.entrySet()) {
            if (key.getKey().getPassport().equals(passport) && key.getKey().getPassport() != null) {
                for (int index = 0; index < this.map.get(key.getKey()).size(); index++) {
                    if (this.map.get(key.getKey()).get(index).equals(account)) {
                        map.get(key.getKey()).remove(index);
                        break;
                    }
                }
            }
        }
    }
    /**
     * Метод получает список аккаунта пользователя
     * @param passport - данные паспорта пользователя типа String
     */
    public List<Account> getUserAccount(String passport) {
        List<Account> list = new ArrayList<>();
        for (Map.Entry<User, List<Account>> key : this.map.entrySet()) {
            if (key.getKey().getPassport().equals(passport) && key.getKey().getPassport() != null) {
                list = this.map.get(key.getKey());
            }
        }
        return list;
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
     * @return метод возвращает найденный в Map аккаунте пользователя
     */
    public Account accountSearchByDetails(String passport, String requisite) {
        Account result = null;
        List<Account> list = getUserAccount(passport);
        for (Account key : list) {
            if (key.getRequisites().equals(requisite)) {
                result = key;
                break;
            }
        }
        return result;
    }
}

