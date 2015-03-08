package com.github.verylargenumber;

public abstract class VeryLargeNumber {
    private static final int DIGITS_AFTER_COMMA = 16;

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
        return new Divide(DIGITS_AFTER_COMMA).perform(new Factory().createFrom(s1),
                new Factory().createFrom(s2)).toString();
    }

    public static final String div(String s1, String s2, int precision) {
        return new Divide(precision).perform(new Factory().createFrom(s1),
                new Factory().createFrom(s2)).toString();
    }
}
