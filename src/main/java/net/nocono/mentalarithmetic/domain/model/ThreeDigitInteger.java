package net.nocono.mentalarithmetic.domain.model;

/**
 * 三桁の整数
 */
public class ThreeDigitInteger implements DigitInteger {
    int value;

    static final int MIN = -999;
    static final int MAX = 999;

    ThreeDigitInteger(int value) {
        if (value < MIN) throw new IllegalArgumentException("不正：" + MIN + "未満");
        if (value > MAX) throw new IllegalArgumentException("不正：" + MAX + "超");

        this.value = value;
    }

    static ThreeDigitInteger valueOf(int value) {
        return new ThreeDigitInteger(value);
    }

    @Override
    public int value() {
        return value;
    }
}
