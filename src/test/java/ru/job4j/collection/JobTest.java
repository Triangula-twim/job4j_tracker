package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(
                new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityAscEqual() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 1)
        );
        assertEquals(rsl, 0);
    }

    @Test
    public void sortByNameUp() {
        List<Job> jobs = new ArrayList<Job>();
        Job first = new Job("c", 1);
        Job second = new Job("d", 5);
        Job third = new Job("a", 3);
        jobs.add(first);
        jobs.add(second);
        jobs.add(third);
        Collections.sort(jobs, new JobAscByName());
        List<Job> expected = List.of(third, first, second);
        assertEquals(jobs, expected);
    }

    @Test
    public void sortByNameDown() {
        List<Job> jobs = new ArrayList<Job>();
        Job first = new Job("a", 1);
        Job second = new Job("d", 5);
        Job third = new Job("c", 3);
        jobs.add(first);
        jobs.add(second);
        jobs.add(third);
        Collections.sort(jobs, new JobDescByName());
        List<Job> expected = List.of(second, third, first);
        assertEquals(jobs, expected);
    }

    @Test
    public void sortByIdUp() {
        List<Job> jobs = new ArrayList<Job>();
        Job first = new Job("a", 1);
        Job second = new Job("d", 5);
        Job third = new Job("c", 3);
        jobs.add(first);
        jobs.add(second);
        jobs.add(third);
        Collections.sort(jobs, new JobAscByPriority());
        List<Job> expected = List.of(first, third, second);
        assertEquals(jobs, expected);
    }

    @Test
    public void sortByIdDown() {
        List<Job> jobs = new ArrayList<Job>();
        Job first = new Job("a", 1);
        Job second = new Job("d", 5);
        Job third = new Job("c", 3);
        jobs.add(first);
        jobs.add(second);
        jobs.add(third);
        Collections.sort(jobs, new JobDescByPriority());
        List<Job> expected = List.of(second, third, first);
        assertEquals(jobs, expected);
    }
}