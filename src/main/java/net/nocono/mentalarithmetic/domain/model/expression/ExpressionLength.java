package net.nocono.mentalarithmetic.domain.model.expression;

import net.nocono.mentalarithmetic.domain.type.Token;
import net.nocono.mentalarithmetic.domain.type.digit.DigitInteger;
import net.nocono.mentalarithmetic.domain.type.operator.Operator;

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
        List<Token> 式 = switch (this) {
            case 数字2個 -> List.of(
                    DigitInteger.random(数字の桁数),
                    DigitInteger.random(数字の桁数),
                    Operator.random());
            case 数字3個 -> {
                if (random.nextBoolean()) {
                    yield List.of(
                            DigitInteger.random(数字の桁数),
                            DigitInteger.random(数字の桁数),
                            Operator.random(),
                            DigitInteger.random(数字の桁数),
                            Operator.random());
                }
                yield List.of(
                        DigitInteger.random(数字の桁数),
                        DigitInteger.random(数字の桁数),
                        DigitInteger.random(数字の桁数),
                        Operator.random(),
                        Operator.random());
            }
        };

        return 式;
    }
}