package com.github.verylargenumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static com.github.verylargenumber.VeryLargeNumber.add;

public class AddUnitTest {

    @Test
    public void addToNull() {
        assertEquals("0", add(null, null));
        assertEquals("12", add("12", null));
        assertEquals("78", add("something dull", "78"));
    }

    @Test
    public void probeAdd() {
        assertEquals("-10023", add("-10002", "-21"));
        assertEquals("456", add("12", "444"));
        assertEquals("71945", add("72663", "-718"));
        assertEquals("-495116", add("-500034", "4918"));
        assertEquals("0", add("-0.23", "0.23"));
        assertEquals("0.3", add("0.1", "0.2"));
        assertEquals("7909.5991", add("7892.81", "16.7891"));
        assertEquals("0.9999921796", add("-0.0000078204", "1"));
    }

}
