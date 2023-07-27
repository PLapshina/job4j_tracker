package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemAscByNameTest {
    @Test
    public void whenSecondItemIsMoreFirst() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "DEF"));
        items.add(new Item(2, "ABC"));
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "ABC"),
                new Item(1, "DEF")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenThirdItemIsMoreSecondAndFirst() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "DEF"));
        items.add(new Item(2, "ABC"));
        items.add(new Item(3, "AAA"));
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(3, "AAA"),
                new Item(2, "ABC"),
                new Item(1, "DEF")
        );
        assertThat(items).isEqualTo(expected);
    }
}