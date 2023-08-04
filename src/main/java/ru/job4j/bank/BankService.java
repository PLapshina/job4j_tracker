package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает логику работы банковского сервиса
 * @author POLINA LAPSHINA
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей системы с привязанными к ним счетами
     * осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя в систему
     * @param user объект класса User (должен быть уникальным).
     * Если пользователь уже есть в системе, то добавление не производится
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя из системы
     * @param passport уникальный номер паспорта пользователя
     * @return возвращает true - если пользователь успешно удален, в иных случаях - false
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Добавляет новый банковский счет уже существующему пользователю
     * @param passport строка с уникальным номером паспорта пользователя,
     *                 по которой производится поиск пользователя по базе
     * @param account объект класса Account (должен быть уникальным)
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Осуществляет поиск пользователя по номеру паспорта
     * @param passport строка с уникальным номером паспорта пользователя
     * @return объект класса User или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Осуществляет поиск банковского счета пользователя по номеру паспорта и номеру счета
     * @param passport строка с номером паспорта
     * @param requisite строка с номером банковского счета
     * @return объект класса Account или null, если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Осуществляет перечисление денежных средств с одного счёта на другой счёт
     * @param srcPassport строка с номером паспорта пользователя,
     *                    осуществляющего перевод денежных средств
     * @param srcRequisite строка с номером счета пользователя,
     *                     с которого осуществляется перевод денежных средств
     * @param destPassport строка с номером паспорта пользователя,
     *                     получающего перевод денежных средств
     * @param destRequisite строка с номером счета пользователя,
     *                      на который осуществляется перевод денежных средств
     * @param amount сумма денежных средств для перечисления
     * @return возвращает true в случае успешного перечисления денежных средств
     * и false - если  счёт не найден или не хватает денег на счёте srcAccount
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Необходим для тестов
     * @param user объект класса User
     * @return возвращает объекты класса Account
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
