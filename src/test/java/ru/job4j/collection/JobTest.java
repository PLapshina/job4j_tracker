package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenJobAscByNameSorted() {
        Job job1 = new Job("Предварительная мойка", 1);
        Job job2 = new Job("Основная мойка", 2);
        Comparator<Job> cmp = new JobAscByName();
        int rsl = cmp.compare(job1, job2);
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenJobDescByNameSorted() {
        Job job1 = new Job("Предварительная мойка", 1);
        Job job2 = new Job("Основная мойка", 2);
        Comparator<Job> cmp = new JobDescByName();
        int rsl = cmp.compare(job1, job2);
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenJobDescByPrioritySorted() {
        Job job1 = new Job("Предварительная мойка", 1);
        Job job2 = new Job("Основная мойка", 2);
        Comparator<Job> cmp = new JobDescByPriority();
        int rsl = cmp.compare(job1, job2);
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenJobAscByPrioritySorted() {
        Job job1 = new Job("Предварительная мойка", 1);
        Job job2 = new Job("Основная мойка", 2);
        Comparator<Job> cmp = new JobAscByPriority();
        int rsl = cmp.compare(job1, job2);
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("AAA", 2),
                new Job("AAA", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Предварительная мойка", 1),
                new Job("Основная мойка", 2)
        );
        assertThat(rsl).isLessThan(0);
    }
}
