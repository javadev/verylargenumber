package com.github.verylargenumber;

import static org.junit.Assert.assertEquals;
import static com.github.verylargenumber.VeryLargeNumber.div;
import static com.github.verylargenumber.VeryLargeNumber.mul;

import org.junit.Test;

public class DivideUnitTest {

    @Test
    public void exact() {
        assertEquals("12.23", div("122.3", "10"));
        assertEquals("89.7777777777777778", div("808", "9"));
        assertEquals("-0.3025555144039548", div("18.789", "-62.101"));
        assertEquals("0.000000310556850299995", div("-0.006263", "-20167"));
        assertEquals("0.00000000001014807901404861", div("9233", "909827366067823"));
        assertEquals("3798979226.6832390120061353", div("718273002389", "189.07"));
        assertEquals("64", div("65536", "1024"));
        assertEquals("0.1428571428571429", div("1", "7"));
        assertEquals("0.99999999999999999999999999999998", mul(div("1", "7", 32), "7"));
    }
}
