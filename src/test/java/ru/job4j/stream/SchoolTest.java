package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

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

    @Test
    public void checkMap() {
        List<Student> list = List.of(new Student("Firsov", 56),
                new Student("Frolov", 39),
                new Student("Vinokuriv", 71),
                new Student("Lyapushkin", 65));
        Map<String, Student> expected = Map.of("Firsov", new Student("Firsov", 56),
                "Frolov", new Student("Frolov", 39),
                "Vinokuriv", new Student("Vinokuriv", 71),
                "Lyapushkin", new Student("Lyapushkin", 65));
        Assert.assertEquals(School.listToMap(list), expected);
    }

    @Test
    public void checkMapIfSame() {
        List<Student> list = List.of(new Student("Firsov", 56),
                new Student("Frolov", 39),
                new Student("Frolov", 71),
                new Student("Lyapushkin", 65));
        Map<String, Student> expected = Map.of("Firsov", new Student("Firsov", 56),
                "Frolov", new Student("Frolov", 39),
                "Lyapushkin", new Student("Lyapushkin", 65));
        Assert.assertEquals(School.listToMap(list), expected);
    }
}