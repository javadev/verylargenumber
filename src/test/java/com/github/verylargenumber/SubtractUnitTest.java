package com.github.verylargenumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static com.github.verylargenumber.VeryLargeNumber.sub;

public class SubtractUnitTest {

    @Test
    public void addToNull() {
        assertEquals("0", sub(null, null));
        assertEquals("12", sub("12", null));
        assertEquals("-11", sub("something dull", "11"));
    }

    @Test
    public void addWithoutOverflow() {
        assertEquals("0", sub("133", "133"));
        assertEquals("-3801", sub("8199", "12000"));
        assertEquals("1282", sub("8971", "7689"));
        assertEquals("-9009200887458", sub("72873665", "9009273761123"));
        assertEquals("220", sub("16.56", "-203.44"));
        assertEquals("0.0379922", sub("1.206", "1.1680078"));
    }

}
