package net.nocono.mentalarithmetic.domain.model.expression.token;

import java.util.Random;

/**
 * 桁数を指定した整数
 */
public class DigitInteger implements Token {
    int value;
    DigitLength length;

    static Random random = new Random();

    public DigitInteger(int value, DigitLength length) {
        if (value < length.MIN()) throw new IllegalArgumentException("不正：" + length.MIN() + "未満");
        if (value > length.MAX()) throw new IllegalArgumentException("不正：" + length.MAX() + "超");

        this.value = value;
        this.length = length;
    }

    public int value() {
        return value;
    }

    public static DigitInteger random(DigitLength length) {
        return new DigitInteger(random.nextInt(length.MAX() * 2 + 1) - length.MAX(), length);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public double toDouble() {
        return (double) value;
    }

    public boolean 負の値() {
        return value < 0;
    }
}
