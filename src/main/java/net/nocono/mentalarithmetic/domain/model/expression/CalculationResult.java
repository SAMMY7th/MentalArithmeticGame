package net.nocono.mentalarithmetic.domain.model.expression;

/**
 * 計算結果
 */
public class CalculationResult {
    double value;

    public CalculationResult(double value) {
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
