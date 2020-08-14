package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SchoolTest {

    @Test
    public void checkA() {
        List<Student> list = List.of(new Student("Firsov", 56),
                new Student("Frolov", 39),
                new Student("Vinokuriv", 71),
                new Student("Lyapushkin", 65));
        List<Student> expected = List.of(new Student("Frolov", 39));
        Assert.assertEquals(School.collect(list, (x) -> x.getScore() < 50), expected);
    }

    @Test
    public void checkB() {
        List<Student> list = List.of(new Student("Firsov", 56),
                new Student("Frolov", 39),
                new Student("Vinokuriv", 71),
                new Student("Lyapushkin", 65));
        List<Student> expected = List.of(new Student("Firsov", 56),
                new Student("Lyapushkin", 65));
        Assert.assertEquals(School.collect(list, (x) ->
                x.getScore() >= 50 && x.getScore() < 70), expected);
    }

    @Test
    public void checkC() {
        List<Student> list = List.of(new Student("Firsov", 56),
                new Student("Frolov", 39),
                new Student("Vinokuriv", 71),
                new Student("Lyapushkin", 65));
        List<Student> expected = List.of(new Student("Vinokuriv", 71));
        Assert.assertEquals(School.collect(list, (x) ->
                x.getScore() >= 70 && x.getScore() <= 100), expected);
    }
}