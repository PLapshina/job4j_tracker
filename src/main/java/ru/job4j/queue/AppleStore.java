package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer rsl = null;
        for (int index = 0; index < count; index++) {
                rsl = queue.poll();
        }
        return rsl == null ? null : rsl.name();
    }

    public String getFirstUpsetCustomer() {
        Customer rsl = null;
        for (int index = 0; index <= count; index++) {
                rsl = queue.poll();
        }
        return rsl == null ? null : rsl.name();
    }
}
