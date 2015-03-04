package com.github.verylargenumber;

import java.util.LinkedList;
import java.util.List;

class Number {

    static final int OFFSET = 48;
    private List<Byte> digits = new LinkedList<Byte>();
    private byte sign = 1;
    private int pointOffset = 0;

    Number() {
    }

    int getDigitsCount() {
        return this.digits.size();
    }

    int getDigit(int i) {
        return i >= digits.size() ? 0 : digits.get(i);
    }

    int getSign() {
        return this.sign;
    }

    Number setSign(int sign) {
        this.sign = (byte) sign;
        return this;
    }

    int getPointOffset() {
        return this.pointOffset;
    }

    Number setPointOffset(int pointOffset) {
        this.pointOffset = pointOffset;
        return this;
    }

    void setDigit(int n, int b) {
        for (int i = digits.size(); i <= n; i++) {
            digits.add((byte) 0);
        }
        digits.set(n, (byte) b);
    }

    void addDigit(int n) {
        digits.add((byte) n);
    }

    @Override
    public String toString() {
        final int size = digits.size();
        final StringBuilder sb = new StringBuilder(size + 2);
        for (int i = 0; i < size; i++) {
            if (i == pointOffset) {
                sb.insert(0, '.');
            }
            final byte b = digits.get(i);
            char c = (char) (b + OFFSET);
            sb.insert(0, c);
        }
        trimLeft(sb);
        trimRight(sb);

        if (-1 == sign && !"0".equals(sb.toString())) {
            sb.insert(0, '-');
        }
        return sb.toString();
    }

    private void trimLeft(StringBuilder sb) {
        while (0 < sb.length()) {
            final char c = sb.charAt(0);
            if (c >= '1' && c <= '9') {
                return;
            } else if ('.' == sb.charAt(1)) {
                return;
            }
            sb.delete(0, 1);
        }
    }

    private void trimRight(StringBuilder sb) {
        while (0 < sb.length()) {
            int n = sb.length() - 1;
            final char c = sb.charAt(n);
            if (c >= '1' && c <= '9') {
                return;
            } else if ('.' == c) {
                sb.delete(n, n + 1);
                return;
            }
            sb.delete(n, n + 1);
        }
    }

    int getMaxDigits(Number that) {
        final int thisSize = this.digits.size();
        final int thatSize = that.digits.size();
        return thisSize > thatSize ? thisSize : thatSize;
    }

    int compareAbs(Number that) {
        setCommonPointOffset(that);
        final int size = getMaxDigits(that);
        for (int i = size - 1; i >= 0; i--) {
            final int thisN = this.getDigit(i);
            final int thatN = that.getDigit(i);
            if (thisN > thatN) {
                return 1;
            } else if (thisN < thatN) {
                return -1;
            }
        }
        return 0;
    }

    boolean isZero() {
        for (int i = 0; i < this.digits.size(); i++) {
            if (0 != this.digits.get(i)) {
                return false;
            }
        }
        return true;
    }

    boolean isA(String str) {
        return toString().equals(str);
    }

    Number multiplyTo10(int times) {
        for (int i = 0; i < times; i++) {
            this.digits.add(0, (byte) 0);
        }
        return this;
    }
    
    void round() {
        if( isZero() || 0==pointOffset ) {
            return;
        }
        final int deltaForRound = getDeltaForRound();
        this.digits.remove(0);
        this.setDigit(0, this.getDigit(0) + deltaForRound );
        this.pointOffset--;
    }
    

    int getDeltaForRound() {
        final int lastDigit = this.digits.get(0);
        final int offset = 5 <= lastDigit ? 1 : 0;
        return offset;
    }

    int setCommonPointOffset(Number that) {
        final int thisN = this.getPointOffset();
        final int thatN = that.getPointOffset();
        final int max = thisN > thatN ? thisN : thatN;
        this.multiplyTo10(max - thisN);
        that.multiplyTo10(max - thatN);
        this.setPointOffset(max);
        that.setPointOffset(max);
        return max;
    }

}
