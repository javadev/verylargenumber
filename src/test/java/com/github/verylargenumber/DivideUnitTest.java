package com.github.verylargenumber;

import static org.junit.Assert.assertEquals;
import static com.github.verylargenumber.VeryLargeNumber.div;

import org.junit.Test;

public class DivideUnitTest {

    @Test
    public void exact() {
        assertEquals("12.23", div("122.3", "10"));
        assertEquals("89.778", div("808", "9"));
        assertEquals("-0.303", div("18.789", "-62.101"));
        assertEquals("0.000000311", div("-0.006263", "-20167"));
        assertEquals("0.0000000000101", div("9233", "909827366067823"));
        assertEquals("3798979226.683", div("718273002389", "189.07"));
        assertEquals("64", div("65536", "1024"));
    }

}
