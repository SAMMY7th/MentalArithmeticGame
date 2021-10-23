package net.nocono.mentalarithmetic.domain.model.expression;

import net.nocono.mentalarithmetic.domain.model.expression.token.DigitInteger;
import net.nocono.mentalarithmetic.domain.model.expression.token.DigitLength;
import net.nocono.mentalarithmetic.domain.model.expression.token.Operator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionTest {

    @Test
    void 計算式の結果を得ることができる() {
        Expression 式 = new Expression(List.of(
                new DigitInteger(1, DigitLength.一桁),
                new DigitInteger(2, DigitLength.一桁),
                Operator.足す));

        assertEquals(new CalculationResult(3d).value(), 式.計算結果().value());
    }

    @Test
    void 数字3個でOperator1の優先度の方が高い計算式の結果を得ることができる() {
        Expression 式 = new Expression(List.of(
                new DigitInteger(1, DigitLength.一桁),
                new DigitInteger(2, DigitLength.一桁),
                Operator.割る,
                new DigitInteger(3, DigitLength.一桁),
                Operator.足す));

        assertEquals(new CalculationResult(3.5d).value(), 式.計算結果().value());
    }

    @Test
    void 数字3個でOperator2の優先度の方が高い計算式の結果を得ることができる() {
        Expression 式 = new Expression(List.of(
                new DigitInteger(1, DigitLength.一桁),
                new DigitInteger(2, DigitLength.一桁),
                new DigitInteger(3, DigitLength.一桁),
                Operator.掛ける,
                Operator.引く));

        assertEquals(new CalculationResult(-5d).value(), 式.計算結果().value());
    }

    @Test
    void toStringメソッドで中置記法の式が表示される() {
        Expression 式 = new Expression(List.of(
                new DigitInteger(1, DigitLength.一桁),
                new DigitInteger(2, DigitLength.一桁),
                Operator.足す));

        assertEquals("1+2", 式.toString());
    }

    @Test
    void 数字3個でOperator1の優先度の方が高い計算式の中置記法の式を得ることができる() {
        Expression 式 = new Expression(List.of(
                new DigitInteger(1, DigitLength.一桁),
                new DigitInteger(2, DigitLength.一桁),
                Operator.割る,
                new DigitInteger(3, DigitLength.一桁),
                Operator.足す));

        assertEquals("1/2+3", 式.toString());
    }

    @Test
    void 数字3個でOperator2の優先度の方が高い計算式の中置記法の式を得ることができる() {
        Expression 式 = new Expression(List.of(
                new DigitInteger(1, DigitLength.一桁),
                new DigitInteger(2, DigitLength.一桁),
                new DigitInteger(3, DigitLength.一桁),
                Operator.掛ける,
                Operator.引く));

        assertEquals("1-2*3", 式.toString());
    }

    @Test
    void 括弧を使った式を出力することができる() {
        Expression 式 = new Expression(List.of(
                new DigitInteger(1, DigitLength.一桁),
                new DigitInteger(2, DigitLength.一桁),
                new DigitInteger(3, DigitLength.一桁),
                Operator.足す,
                Operator.掛ける));

        assertEquals("1*(2+3)", 式.toString());
    }

    @Test
    void 先頭以外の負の値には括弧がつく() {
        Expression 式 = new Expression(List.of(
                new DigitInteger(-1, DigitLength.一桁),
                new DigitInteger(-2, DigitLength.一桁),
                new DigitInteger(-3, DigitLength.一桁),
                Operator.足す,
                Operator.掛ける));

        assertEquals("-1*((-2)+(-3))", 式.toString());
    }
}