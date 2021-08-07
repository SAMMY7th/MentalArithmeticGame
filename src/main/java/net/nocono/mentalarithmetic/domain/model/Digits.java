package net.nocono.mentalarithmetic.domain.model;

/**
 * 数字の桁数
 */
public enum Digits {
    一桁(-9, 9), 二桁(-99, 99), 三桁(-999, 999);

    int min;
    int max;

    Digits(int min, int max) {
        this.min = min;
        this.max = max;
    }
}
