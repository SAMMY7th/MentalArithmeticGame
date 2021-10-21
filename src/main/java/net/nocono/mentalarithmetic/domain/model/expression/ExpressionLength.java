package net.nocono.mentalarithmetic.domain.model.expression;

import net.nocono.mentalarithmetic.domain.model.expression.token.Token;
import net.nocono.mentalarithmetic.domain.model.expression.token.DigitInteger;
import net.nocono.mentalarithmetic.domain.model.expression.token.Operator;

import java.util.List;
import java.util.Random;

/**
 * 式の長さ
 */
public enum ExpressionLength {
    数字2個,
    数字3個;

    Random random = new Random();

    public List<Token> 式生成(DigitLength 数字の桁数) {
        switch (this) {
            case 数字2個:
                return List.of(
                    DigitInteger.random(数字の桁数),
                    DigitInteger.random(数字の桁数),
                    Operator.random());
            case 数字3個: {
                if (random.nextBoolean()) {
                    return List.of(
                            DigitInteger.random(数字の桁数),
                            DigitInteger.random(数字の桁数),
                            Operator.random(),
                            DigitInteger.random(数字の桁数),
                            Operator.random());
                }
                return List.of(
                        DigitInteger.random(数字の桁数),
                        DigitInteger.random(数字の桁数),
                        DigitInteger.random(数字の桁数),
                        Operator.random(),
                        Operator.random());
            }
            default: List.of();
        }

        return List.of();
    }
}
