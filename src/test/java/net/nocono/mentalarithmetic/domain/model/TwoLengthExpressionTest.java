package net.nocono.mentalarithmetic.domain.model;

import net.nocono.mentalarithmetic.domain.type.operator.Operator;
import net.nocono.mentalarithmetic.domain.type.digit.SingleDigitInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoLengthExpressionTest {

    @Test
    void 数字２個の計算式の結果を得ることができる() {
        TwoLengthExpression twoLengthExpression =
                new TwoLengthExpression(SingleDigitInteger.valueOf(1), Operator.足す, SingleDigitInteger.valueOf(2));
        CalculationResult 計算結果 = twoLengthExpression.計算結果();

        assertEquals(new CalculationResult(3d).value, 計算結果.value);
    }

    @Test
    void ゼロ除算発生の判定ができる() {
        TwoLengthExpression twoLengthExpression =
                new TwoLengthExpression(SingleDigitInteger.valueOf(1), Operator.割る, SingleDigitInteger.valueOf(0));

        assertTrue(twoLengthExpression.ゼロ除算発生());
    }
}