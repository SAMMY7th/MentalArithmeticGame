package net.nocono.mentalarithmetic.domain.model.expression;

import net.nocono.mentalarithmetic.domain.type.digit.DigitInteger;
import net.nocono.mentalarithmetic.domain.type.operator.Operator;

/**
 * 数字が３個の数式
 */
public class ThreeLengthExpression implements Expression {
    DigitInteger number1;
    Operator operator1;
    DigitInteger number2;
    Operator operator2;
    DigitInteger number3;

    public ThreeLengthExpression(DigitInteger number1, Operator operator1, DigitInteger number2, Operator operator2, DigitInteger number3) {
        this.number1 = number1;
        this.operator1 = operator1;
        this.number2 = number2;
        this.operator2 = operator2;
        this.number3 = number3;
    }

    @Override
    public CalculationResult 計算結果() {
        if (operator2.の方がターゲットより優先順位が高い(operator1)) {
            return new CalculationResult(operator1.apply(number1.value(), operator2.apply(number2.value(), number3.value())));
        }

        return new CalculationResult(operator2.apply(operator1.apply(number1.value(), number2.value()), number3.value()));
    }

    @Override
    public boolean ゼロ除算発生() {
        if (Double.isInfinite(計算結果().value())) return true;

        return false;
    }

    @Override
    public String toString() {
        return number1.toString() + operator1.toString() + number2.toString() + operator2.toString() + number3.toString();
    }
}
