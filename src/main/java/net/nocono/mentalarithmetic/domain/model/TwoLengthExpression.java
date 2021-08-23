package net.nocono.mentalarithmetic.domain.model;

import net.nocono.mentalarithmetic.domain.type.digit.DigitInteger;
import net.nocono.mentalarithmetic.domain.type.operator.Operator;

/**
 * 数字が２個の数式
 */
public class TwoLengthExpression implements Expression {
    DigitInteger number1;
    Operator operator;
    DigitInteger number2;

    TwoLengthExpression(DigitInteger number1, Operator operator, DigitInteger number2) {
        this.number1 = number1;
        this.operator = operator;
        this.number2 = number2;
    }

    @Override
    public CalculationResult 計算結果() {
        return new CalculationResult(operator.apply(number1.value(), number2.value()));
    }

    @Override
    public String toString() {
        return number1.toString() + operator.toString() + number2.toString();
    }
}
