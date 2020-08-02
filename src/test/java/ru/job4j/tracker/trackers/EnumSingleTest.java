package ru.job4j.tracker.trackers;

import org.junit.Test;

import static org.junit.Assert.*;

public class EnumSingleTest {

    @Test
    public void values() {
       assertSame(EnumSingle.INSTANCE, EnumSingle.INSTANCE);
    }
}