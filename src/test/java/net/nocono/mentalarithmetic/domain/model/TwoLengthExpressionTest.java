package net.nocono.mentalarithmetic.domain.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoLengthExpressionTest {

    @Test
    @Disabled
    void 数字２個の計算式の結果を得ることができる() {
        TwoLengthExpression twoLengthExpression =
                new TwoLengthExpression(SingleDigitInteger.valueOf(1), Operator.足す, SingleDigitInteger.valueOf(2));
        CalculationResult 計算結果 = twoLengthExpression.計算結果();

        assertEquals(new CalculationResult(3d).value, 計算結果.value);
    }
}