package net.nocono.mentalarithmetic.domain.model;

/**
 * 計算結果
 */
public class CalculationResult {
    double value;

    CalculationResult(double value) {
        this.value = value;
    }

    public double value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
