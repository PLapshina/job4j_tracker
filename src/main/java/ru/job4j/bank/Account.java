package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета пользователя
 * @author POLINA LAPSHINA
 * @version 1.0
 */
public class Account {
    /**
     * Содержит реквизиты банковского счета
     */
    private String requisite;
    /**
     * Содержит баланс счета
     */
    private double balance;

    /**
     * Конструктор нового счета
     * @param requisite уникальный номер банковского счета
     * @param balance баланс банковского счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * get-метод поля requisite
     * @return возвращает строку с номером банковского счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * set-метод поля requisite
     * @param requisite строка с номером банковского счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * get-метод поля balance
     * @return баланс банковского счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * set-метод поля balance
     * @param balance значение баланса банковского счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * метод проверяет на идентичность объекты класса Account на основании значений поля requisite
     * @param o объект класса Account для сравнения его с текущим
     * @return возвращает true, если объекты равны, и false - если объекты не равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Вычисляет хэш-кода для текущего объекта класса Account на основании значения поля requisite
     * @return значение хэш-кода для объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
