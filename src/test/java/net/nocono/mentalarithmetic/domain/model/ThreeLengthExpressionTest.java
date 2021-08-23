package net.nocono.mentalarithmetic.domain.model;

import net.nocono.mentalarithmetic.domain.type.digit.DigitInteger;
import net.nocono.mentalarithmetic.domain.type.operator.Operator;
import net.nocono.mentalarithmetic.domain.type.digit.SingleDigitInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeLengthExpressionTest {

    @Test
    void 数字3個でOperator1の優先度の方が高い計算式の結果を得ることができる() {
        DigitInteger number1 = SingleDigitInteger.valueOf(1);
        Operator operator1 = Operator.割る;
        DigitInteger number2 = SingleDigitInteger.valueOf(2);
        Operator operator2 = Operator.足す;
        DigitInteger number3 = SingleDigitInteger.valueOf(3);

        ThreeLengthExpression threeLengthExpression =
                new ThreeLengthExpression(number1, operator1, number2, operator2, number3);
        CalculationResult 計算結果 = threeLengthExpression.計算結果();

        assertEquals(new CalculationResult(3.5d).value, 計算結果.value);
    }

    @Test
    void 数字3個でOperator2の優先度の方が高い計算式の結果を得ることができる() {
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

    @Test
    void 数字3個でOperator1とOperator2の優先度が同等の計算式の結果を得ることができる() {
        DigitInteger number1 = SingleDigitInteger.valueOf(1);
        Operator operator1 = Operator.足す;
        DigitInteger number2 = SingleDigitInteger.valueOf(2);
        Operator operator2 = Operator.引く;
        DigitInteger number3 = SingleDigitInteger.valueOf(3);

        ThreeLengthExpression threeLengthExpression =
                new ThreeLengthExpression(number1, operator1, number2, operator2, number3);
        CalculationResult 計算結果 = threeLengthExpression.計算結果();

        assertEquals(new CalculationResult(0d).value, 計算結果.value);
    }
}