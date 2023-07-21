package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ivanov.ivan@yandex.ru", "Ivanov Ivan Ivanovich");
        map.put("ivanov.ivan@yandex.ru", "Ivanov Ivan Petrovich");
        map.put("polina.lapshina@mail.ru", "Ivanova Polina Nikolaevna");
        map.put("polina.lapshina@mail.ru", "Lapshina Polina Nikolaevna");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
