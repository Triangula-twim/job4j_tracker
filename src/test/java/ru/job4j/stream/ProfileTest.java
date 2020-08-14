package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProfileTest {
    @Test
    public void checkA() {
        List<Profile> list = List.of(new Profile(new Address("Samara", "Tovarnaya", 5, 63)));
        List<Address> expected = List.of(new Address("Samara", "Tovarnaya", 5, 63));
        Assert.assertEquals(Profile.collect(list), expected);
    }
}