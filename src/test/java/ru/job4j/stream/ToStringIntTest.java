package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ToStringIntTest {

    @Test
    public void check() {
        Integer[][] array = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        Assert.assertEquals(ToStringInt.convert(array), expected);
    }

    @Test
    public void checkB() {
        Integer[][] array = {{1, 2}, {3, 4, 5}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        Assert.assertEquals(ToStringInt.convert(array), expected);
    }
}