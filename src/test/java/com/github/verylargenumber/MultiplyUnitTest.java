package com.github.verylargenumber;

import static org.junit.Assert.assertEquals;
import static com.github.verylargenumber.VeryLargeNumber.mul;

import org.junit.Test;

public class MultiplyUnitTest {


    @Test
    public void mulToZero() {
        assertEquals("0", mul(null, null));
        assertEquals("0", mul("788", "0"));
        assertEquals("0", mul("578", "not a number"));
    }

    @Test
    public void mulToOne() {
        assertEquals("178", mul("1", "178"));
        assertEquals("67", mul("67", "1"));
    }

    @Test
    public void mulWithoutOverflow() {
        assertEquals("6", mul("2", "3"));
        assertEquals("9", mul("3", "3"));
    }

    @Test
    public void mulWithOverflow() {
        assertEquals("72", mul("12", "6"));
        assertEquals("5367788526", mul("67162", "79923"));
    }
    
    @Test
    public void mulWithPoint() {
        assertEquals("0.56112", mul("0.14", "4.008"));
        assertEquals("-75139.36967772", mul("-780.93", "96.217804"));
        assertEquals("343974061943318.89", mul("-857790678162.89", "-401"));
    }   

    @Test
    public void factorial() {
        assertEquals("1", factorial(0));
        assertEquals("720", factorial(6));
        assertEquals(
                "30414093201713378043612608166064768844377641568960512000000000000",
                factorial(50));
        assertEquals(
                "933262154439441526816992388562667004907159682643816214685929638952"
                        + "1759999322991560894146397615651828625369792082"
                        + "7223758251185210916864000000000000000000000000",
                factorial(100));
    }

    private static String factorial(int n) {
        String result = "1";
        for (int i = 1; i <= n; i++) {
            result = mul(result, String.valueOf(i));
        }
        return result;
    }

}
