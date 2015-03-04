package com.github.verylargenumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrivialDivideUnitTest {

    @Test(expected = IllegalArgumentException.class)
    public void divToZero() {
        assertEquals("", div(null, null));
        assertEquals("", div("107273", null));
        assertEquals("", div("-6782.80823", "something dull"));
        assertEquals("", div("0.1782", "0"));
    }

    @Test
    public void trivial() {
        divWithRest("182773", "0", "182773", "1");
        divWithRest("-16", "0", "16", "-1");
        divWithRest("77", "0", "-77", "-1");
        divWithRest("-1", "0", "101", "-101");
        divWithRest("1", "0", "8291", "8291");
    }

    private void divWithRest(String expectedResult, String expectedRest,
            String s1, String s2) {
        final String[] actual = div(s1, s2);
        assertEquals(expectedResult, actual[0]);
        assertEquals(expectedRest, actual[1]);
    }

    private static String[] div(String s1, String s2) {
        final Number n1 = new Factory().createFrom(s1);
        final Number n2 = new Factory().createFrom(s2);
        final TrivialDivide div = new TrivialDivide();
        Number result = div.perform(n1, n2);
        return new String[] { result.toString(), div.getRest().toString() };
    }
}
