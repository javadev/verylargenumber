package com.github.verylargenumber;

class DivideWithRest extends BinaryOperation {

    private final String[] digitProducts = new String[10];
    private Number lastProbe = null;
    private Number rest = new Factory().createZero();
    private int sign = 1;
    private final SubtractAbs subtractAbs = new SubtractAbs();

    DivideWithRest() {
        this.digitProducts[0] = "0";
    }

    @Override
    Number perform(Number n1, Number n2) {
        final TrivialDivide trivialDivide = new TrivialDivide();
        final Number trivial = trivialDivide.perform(n1, n2);
        if (null != trivial) {
            rest = trivialDivide.getRest();
            return trivial;
        }
        // Arrange point offsets:
        n1.setCommonPointOffset(n2);
        n1.setPointOffset(0);
        n2.setPointOffset(0);

        prepareDigitProducts(n2);

        final Number result = new Number();
        final int orderDiff = getOrderDifference(n1, n2);
        this.rest = n1;
        for (int order = orderDiff; order >= 0; order--) {
            int digit = findDigit(order);
            result.setDigit(order, digit);
            this.rest = this.subtractAbs.perform(rest, lastProbe);
        }

        result.setSign(sign);
        return result;
    }

    Number getRest() {
        return rest;
    }

    private void prepareDigitProducts(Number n) {
        for (int i = 1; i < this.digitProducts.length; i++) {
            this.digitProducts[i] = VeryLargeNumber.mul(n.toString(), String.valueOf(i));
        }
    }

    private int findDigit(int order) {
        for (int i = 9; i >= 0; i--) {
            this.lastProbe = new Factory().createFrom(this.digitProducts[i])
                    .multiplyTo10(order);
            if (0 >= this.lastProbe.compareAbs(rest)) {
                return i;
            }
        }
        return 0;
    }

    // Difference of the number orders
    private int getOrderDifference(Number n1, Number n2) {
        final int size1 = n1.getDigitsCount() - n1.getPointOffset();
        final int size2 = n2.getDigitsCount() - n2.getPointOffset();
        return size1 - size2;
    }

}
