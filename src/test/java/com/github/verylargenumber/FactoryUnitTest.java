package com.github.verylargenumber;

import org.junit.Test;
import com.github.verylargenumber.Factory;

import static org.junit.Assert.assertEquals;

public class FactoryUnitTest {

    @Test
    public void invalidValues() {
        assertEquals("0", new Factory().createFrom(null).toString());
        assertEquals("0", new Factory().createFrom("").toString());
        assertEquals("0", new Factory().createFrom("10-0").toString());
        assertEquals("0", new Factory().createFrom(".728378").toString());
        assertEquals("0", new Factory().createFrom("18.728.37823.8").toString());
        assertEquals("-978", new Factory().createFrom("-9ab7h8").toString());
    }
}
