package com.github.verylargenumber;

class Divide extends BinaryOperation {

    @Override
    Number perform(Number n1, Number n2) {
        if (n2.isZero()) {
            throw new IllegalArgumentException("Divide by zero");
        }
        final DivideWithRest divideBeforePoint = new DivideWithRest();
        final Number beforePoint = divideBeforePoint.perform(n1, n2);
        final Number rest = divideBeforePoint.getRest();
        if( rest.isZero() ) {
            return beforePoint;
        }

        int count = 0;
        while (0 > rest.compareAbs(n2)) {
            count++;
            rest.multiplyTo10(1);
        }
        rest.multiplyTo10(3);
        count += 3;

        beforePoint.multiplyTo10(count);

        final DivideWithRest divideAfterPoint = new DivideWithRest();
        final Number afterPoint = divideAfterPoint.perform(rest, n2);

        final Number result = new AddAbs().perform(beforePoint, afterPoint);
        result.setSign(n1.getSign() * n2.getSign());
        result.setPointOffset(count);
        result.round();

        return result;
    }

}
