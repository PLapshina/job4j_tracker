package ru.job4j.queue;

import java.util.LinkedList;
import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Queue<Customer> customers = new LinkedList<>(queue);
        Customer rsl = null;
        if (!customers.isEmpty()) {
            for (int index = 0; index < count; index++) {
                rsl = customers.poll();
            }
        }
        return rsl == null ? null : rsl.name();
    }

    public String getFirstUpsetCustomer() {
        Queue<Customer> customers = new LinkedList<>(queue);
        Customer rsl = null;
        if (!customers.isEmpty()) {
            for (int index = 0; index <= count; index++) {
                rsl = customers.poll();
            }
        }
        return rsl == null ? null : rsl.name();
    }
}
