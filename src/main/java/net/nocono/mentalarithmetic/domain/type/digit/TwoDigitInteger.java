package net.nocono.mentalarithmetic.domain.type.digit;

/**
 * 二桁の整数
 */
public class TwoDigitInteger implements DigitInteger {
    int value;

    static final int MIN = -99;
    static final int MAX = 99;

    TwoDigitInteger(int value) {
        if (value < MIN) throw new IllegalArgumentException("不正：" + MIN + "未満");
        if (value > MAX) throw new IllegalArgumentException("不正：" + MAX + "超");

        this.value = value;
    }

    static TwoDigitInteger valueOf(int value) {
        return new TwoDigitInteger(value);
    }

    @Override
    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
