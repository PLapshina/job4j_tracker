package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банковского сервиса
 * @author POLINA LAPSHINA
 * @version 1.0
 */
public class User {
    /**
     * Содержит номер паспорта пользователя
     */
    private String passport;

    /**
     * Содержит ФИО пользователя
     */
    private String username;

    /**
     * Конструктор нового пользователя
     * @param passport уникальный номер паспорта пользователя
     * @param username ФИО пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * get-метод поля passport
     * @return возвращает строку с номером паспорта пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * set-метод поля passport
     * @param passport строка с номером паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * get-метод поля username
     * @return возвращает строку с фамилией, именем, отчеством пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * set-метод поля username
     * @param username строка с фамилией, именем, отчеством пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * метод проверяет на идентичность объекты класса User на основании значений поля passport
     * @param o объект класса User для сравнения его с текущим
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Вычисляет хэш-кода для текущего объекта класса User на основании значения поля passport
     * @return значение хэш-кода для объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
