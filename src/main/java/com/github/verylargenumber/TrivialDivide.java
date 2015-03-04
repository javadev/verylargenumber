package com.github.verylargenumber;

class TrivialDivide extends BinaryOperation {

    private Number rest = new Factory().createZero();

    @Override
    Number perform(Number n1, Number n2) {
        if (n2.isZero()) {
            throw new IllegalArgumentException("Divide by zero");
        }
        if (n1.isZero() || n2.isA("1")) {
            return new Factory().createCopy(n1);
        }
        if (n2.isA("-1")) {
            final Number result = new Factory().createCopy(n1);
            result.setSign(-result.getSign());
            return result;
        }

        final int compareAbs = n1.compareAbs(n2);
        int sign = n1.getSign() * n2.getSign();

        if (0 > compareAbs) {
            this.rest = new Factory().createCopy(n1);
            return new Factory().createZero();
        } else if (0 == compareAbs) {
            return new Factory().createFrom("1").setSign(sign);
        }
        return null;
    }

    Number getRest() {
        return rest;
    }

}
