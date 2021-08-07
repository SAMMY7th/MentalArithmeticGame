package net.nocono.mentalarithmetic.domain.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeLengthExpressionTest {

    @Test
    @Disabled
    void 数字3個の計算式の結果を得ることができる() {
        DigitInteger number1 = SingleDigitInteger.valueOf(1);
        Operator operator1 = Operator.引く;
        DigitInteger number2 = SingleDigitInteger.valueOf(2);
        Operator operator2 = Operator.掛ける;
        DigitInteger number3 = SingleDigitInteger.valueOf(3);

        ThreeLengthExpression threeLengthExpression =
                new ThreeLengthExpression(number1, operator1, number2, operator2, number3);
        CalculationResult 計算結果 = threeLengthExpression.計算結果();

        assertEquals(new CalculationResult(-5d).value, 計算結果.value);
    }
}