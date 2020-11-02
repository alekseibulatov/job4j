package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmNamePriority = new SortByDownNameJob().thenComparing(new SortByDownPriorityJob());
        int rsl = cmNamePriority.compare(new Job("Impl task", 0), new Job("Fix bug", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityUp() {
        Comparator<Job> cmNamePriority = new SortByUpNameJob().thenComparing(new SortByUpPriorityJob());
        int rsl = cmNamePriority.compare(new Job("Fix bug", 0), new Job("Fix bug", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByName() {
        Comparator<Job> cmNamePriority = new SortByUpNameJob();
        int rsl = cmNamePriority.compare(new Job("Fix bug", 0), new Job("Fix bug", 1));
        assertThat(rsl, is(0));
    }

    @Test
    public void whenComparatorByPriority() {
        Comparator<Job> cmNamePriority = new SortByUpPriorityJob();
        int rsl = cmNamePriority.compare(new Job("Fix bug", 0), new Job("Fix bug", 1));
        assertThat(rsl, is(-1));
    }

    @Test
    public void whenComparatorByNameDown() {
        Comparator<Job> cmNamePriority = new SortByDownNameJob();
        int rsl = cmNamePriority.compare(new Job("Impl task", 0), new Job("Fix bug", 1));
        assertThat(rsl, is(-3));
    }

    @Test
    public void whenComparatorByPriorityDown() {
        Comparator<Job> cmNamePriority = new SortByDownPriorityJob();
        int rsl = cmNamePriority.compare(new Job("Impl task", 0), new Job("Fix bug", 1));
        assertThat(rsl, is(1));
    }
}
