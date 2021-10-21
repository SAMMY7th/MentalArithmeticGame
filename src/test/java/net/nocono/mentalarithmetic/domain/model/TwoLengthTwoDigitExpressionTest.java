package net.nocono.mentalarithmetic.domain.model;

import net.nocono.mentalarithmetic.domain.model.expression.CalculationResult;
import net.nocono.mentalarithmetic.domain.model.expression.TwoLengthTwoDigitExpression;
import net.nocono.mentalarithmetic.domain.type.operator.Operator;
import net.nocono.mentalarithmetic.domain.type.digit.SingleDigitInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoLengthTwoDigitExpressionTest {

    @Test
    void 数字２個の計算式の結果を得ることができる() {
        TwoLengthTwoDigitExpression twoLengthTwoDigitExpression =
                new TwoLengthTwoDigitExpression(SingleDigitInteger.valueOf(1), Operator.足す, SingleDigitInteger.valueOf(2));
        CalculationResult 計算結果 = twoLengthTwoDigitExpression.計算結果();

        assertEquals(new CalculationResult(3d).value(), 計算結果.value());
    }

    @Test
    void ゼロ除算発生の判定ができる() {
        TwoLengthTwoDigitExpression twoLengthTwoDigitExpression =
                new TwoLengthTwoDigitExpression(SingleDigitInteger.valueOf(1), Operator.割る, SingleDigitInteger.valueOf(0));

        assertTrue(twoLengthTwoDigitExpression.ゼロ除算発生());
    }
}