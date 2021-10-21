package net.nocono.mentalarithmetic.domain.model.expression;

/**
 * 整数の桁数
 */
public enum DigitLength {
    一桁(-9, 9),
    二桁(-99, 99),
    三桁(-999, 999);

    int MIN;
    int MAX;

    DigitLength(int MIN, int MAX) {
        this.MIN = MIN;
        this.MAX = MAX;
    }

    public int MIN() {
        return MIN;
    }

    public int MAX() {
        return MAX;
    }
}
