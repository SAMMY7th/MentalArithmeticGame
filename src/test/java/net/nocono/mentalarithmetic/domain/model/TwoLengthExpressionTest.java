package net.nocono.mentalarithmetic.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoLengthExpressionTest {

    @Test
    void 数字２個の計算式の結果を得ることができる() {
        TwoLengthExpression twoLengthExpression =
                new TwoLengthExpression(Number.of(1, Digits.一桁), Operator.足す, Number.of(2, Digits.一桁));
        CalculationResult 計算結果 = twoLengthExpression.計算結果();

        assertEquals(new CalculationResult(3d).value, 計算結果.value);
    }
}