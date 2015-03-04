package com.github.verylargenumber;

class AddAbs extends BinaryOperation {

    @Override
    Number perform(Number n1, Number n2) {
        final int pointOffset = n1.setCommonPointOffset(n2);
        final Number result = new Factory().createZero();
        final int max = n1.getMaxDigits(n2);
        int prev = 0;
        for (int i = 0; i < max; i++) {
            final int n = n1.getDigit(i) + n2.getDigit(i) + prev;
            prev = n / 10;
            result.setDigit(i, n % 10);
        }
        result.addDigit(prev);
        result.setPointOffset(pointOffset);
        return result;
    }

}
