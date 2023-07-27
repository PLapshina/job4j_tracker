package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemDescByNameTest {
    @Test
    public void whenSortInDescending() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "DEF"));
        items.add(new Item(2, "ABC"));
        items.add(new Item(3, "STU"));
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(3, "STU"),
                new Item(1, "DEF"),
                new Item(2, "ABC")
        );
        assertThat(items).isEqualTo(expected);
    }
}