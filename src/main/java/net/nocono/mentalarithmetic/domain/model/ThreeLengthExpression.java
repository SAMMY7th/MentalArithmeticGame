package net.nocono.mentalarithmetic.domain.model;

/**
 * 数字が３個の数式
 */
public class ThreeLengthExpression implements Expression {
    DigitInteger number1;
    Operator operator1;
    DigitInteger number2;
    Operator operator2;
    DigitInteger number3;

    ThreeLengthExpression(DigitInteger number1, Operator operator1, DigitInteger number2, Operator operator2, DigitInteger number3) {
        this.number1 = number1;
        this.operator1 = operator1;
        this.number2 = number2;
        this.operator2 = operator2;
        this.number3 = number3;
    }

    @Override
    public CalculationResult 計算結果() {
        return null;
    }
}
