package net.nocono.mentalarithmetic.domain.model;

/**
 * 数字が３個の数式
 */
public class ThreeLengthExpression implements Expression {
    Number number1;
    Operator operator1;
    Number number2;
    Operator operator2;
    Number number3;

    ThreeLengthExpression(Number number1, Operator operator1, Number number2, Operator operator2, Number number3) {
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
