package ru.job4j.tracker.trackers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SFLLSingleTest {

    @Test
    public void values() {
        assertSame(SFLLSingle.getInstance(), SFLLSingle.getInstance());
    }
}