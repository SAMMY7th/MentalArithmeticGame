package net.nocono.mentalarithmetic.domain.model;

import java.util.Random;

/**
 * 一桁の整数
 */
public class SingleDigitInteger implements DigitInteger {
    int value;

    static final int MIN = -9;
    static final int MAX = 9;

    static Random random = new Random();

    SingleDigitInteger(int value) {
        if (value < MIN) throw new IllegalArgumentException("不正：" + MIN + "未満");
        if (value > MAX) throw new IllegalArgumentException("不正：" + MAX + "超");

        this.value = value;
    }

    static SingleDigitInteger valueOf(int value) {
        return new SingleDigitInteger(value);
    }

    @Override
    public int value() {
        return value;
    }

    static SingleDigitInteger random() {
        return new SingleDigitInteger(random.nextInt(19) - 9);
    }
}
