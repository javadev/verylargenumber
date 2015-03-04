package com.github.verylargenumber;

import org.junit.Test;
import com.github.verylargenumber.Factory;
import com.github.verylargenumber.Number;
import com.github.verylargenumber.SubtractAbs;

import static org.junit.Assert.assertEquals;

public class SubtractAbsUnitTest {

    @Test
    public void subNull() {
        assertEquals("0", sub(null, null));
        assertEquals("12", sub("12", null));
        assertEquals("78", sub("78", "something dull"));
    }

    @Test
    public void subWithoutOverflow() {
        assertEquals("11", sub("12", "1"));
        assertEquals("114", sub("349", "235"));
    }

    @Test
    public void subWithOverflow() {
        assertEquals("794", sub("800", "6"));
        assertEquals("226", sub("1024", "798"));
        assertEquals("692446", sub("781727", "89281"));
        assertEquals("0.8845", sub("2.0045", "-1.12"));
        assertEquals("3001749.108809323262544438",
                sub("3001828.0000182", "78.891208876737455562"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void when1stArgIsLessThan2ndThenThrowException() {
        assertEquals("794", sub("8", "600"));
    }

    private static String sub(String s1, String s2) {
        Number n1 = new Factory().createFrom(s1);
        Number n2 = new Factory().createFrom(s2);
        Number result = new SubtractAbs().perform(n1, n2);
        return result.toString();
    }

}
