package com.github.verylargenumber;

class Factory {

    Number createCopy(Number src) {
        Number result = new Number();
        result.setSign(src.getSign());
        result.setPointOffset(src.getPointOffset());
        for (int i = 0; i < src.getDigitsCount(); i++) {
            result.addDigit(src.getDigit(i));
        }
        return result;
    }

    Number createZero() {
        return createFrom("0");
    }

    Number createFrom(String str) {
        final String src = isInvalid(str) ? "0" : str;
        final Number result = new Number();
        for (int i = src.length() - 1; i >= 0; i--) {
            char c = src.charAt(i);
            if ('-' == c) {
                result.setSign(-1);
            } else if ('.' == c) {
                result.setPointOffset(result.getDigitsCount());
            } else if (Character.isDigit(c)) {
                c -= Number.OFFSET;
                result.addDigit(c);
            }
        }
        return result;
    }

    private boolean isInvalid(String str) {
        if (null == str || str.isEmpty()) {
            return true;
        }
        boolean atLeastOneDigit = false;
        boolean pointIsFound = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('-' == c && 0 != i) {
                // Minus can't be found at the position, which differs from 1st
                return true;
            } else if ('.' == c) {
                if (0 == i) {
                    // Point can't be placed at 1st position
                    return true;
                } else if (pointIsFound) {
                    // More than one point is not allowed
                    return true;
                } else {
                    pointIsFound = true;
                }
            } else if (Character.isDigit(c)) {
                atLeastOneDigit = true;
            }
        }
        if (!atLeastOneDigit) {
            return true;
        }
        return false;
    }

}
