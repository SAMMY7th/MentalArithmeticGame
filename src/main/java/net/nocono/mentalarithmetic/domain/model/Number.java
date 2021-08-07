package net.nocono.mentalarithmetic.domain.model;

/**
 * 数字
 */
public class Number {
    int value;
    Digits digits;

    Number(int value, Digits digits) {
        this.value = value;
        this.digits = digits;
    }

    public static Number of(int value, Digits digits) {
        return new Number(value, digits);
    }
}
