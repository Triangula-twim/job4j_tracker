package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProfileTest {
    @Test
    public void checkA() {
        List<Profile> list = List.of(new Profile(new Address("Samara", "Tovarnaya", 5, 63)));
        List<Address> expected = List.of(new Address("Samara", "Tovarnaya", 5, 63));
        Assert.assertEquals(Profiles.collect(list), expected);
    }

    @Test
    public void sortedDuplicate() {
        List<Profile> list = List.of(new Profile(new Address("Samara", "Tovarnaya", 5, 63)),
                new Profile(new Address("Kinel'", "Dvorovaya", 3, 12)),
                new Profile(new Address("Samara", "Tovarnaya", 5, 63)));
        List<Address> expected = List.of(new Address("Kinel'", "Dvorovaya", 3, 12),
                new Address("Samara", "Tovarnaya", 5, 63));
        Assert.assertEquals(Profiles.collectUniq(Profiles.collect(list)), expected);
    }
}