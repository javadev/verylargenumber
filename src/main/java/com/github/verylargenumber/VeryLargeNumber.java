package com.github.verylargenumber;

public abstract class VeryLargeNumber {

    public static final String add(String s1, String s2) {
        return new Add().perform(new Factory().createFrom(s1),
                new Factory().createFrom(s2)).toString();
    }

    public static final String mul(String s1, String s2) {
        return new Multiply().perform(new Factory().createFrom(s1),
                new Factory().createFrom(s2)).toString();
    }

    public static final String sub(String s1, String s2) {
        return new Subtract().perform(new Factory().createFrom(s1),
                new Factory().createFrom(s2)).toString();
    }
    
    public static final String div(String s1, String s2) {
        return new Divide().perform(new Factory().createFrom(s1),
                new Factory().createFrom(s2)).toString();
    }
}
