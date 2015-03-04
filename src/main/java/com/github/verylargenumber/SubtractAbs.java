package com.github.verylargenumber;

class SubtractAbs extends BinaryOperation {

    @Override
    Number perform(Number n1, Number n2) {
        final int pointOffset = n1.setCommonPointOffset(n2);
        if (0 > n1.compareAbs(n2)) {
            throw new IllegalArgumentException(
                    "The 1st argument's absolute value is less that 2nd one");
        }
        final Number result = new Factory().createZero();
        final int max = n1.getMaxDigits(n2);
        for (int i = 0; i < max; i++) {
            int b1 = n1.getDigit(i);
            final int b2 = n2.getDigit(i);
            if (b1 < b2) {
                b1 += 10;
                n1.setDigit(i + 1, n1.getDigit(i + 1) - 1);
            }
            result.setDigit(i, b1 - b2);
        }
        result.setPointOffset(pointOffset);
        return result;
    }

}
