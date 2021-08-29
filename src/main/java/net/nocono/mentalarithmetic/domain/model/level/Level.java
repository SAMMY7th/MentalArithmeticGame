package net.nocono.mentalarithmetic.domain.model.level;

import net.nocono.mentalarithmetic.domain.model.expression.Expression;
import net.nocono.mentalarithmetic.domain.model.expression.ThreeLengthExpression;
import net.nocono.mentalarithmetic.domain.model.expression.TwoLengthExpression;
import net.nocono.mentalarithmetic.domain.type.digit.SingleDigitInteger;
import net.nocono.mentalarithmetic.domain.type.digit.ThreeDigitInteger;
import net.nocono.mentalarithmetic.domain.type.digit.TwoDigitInteger;
import net.nocono.mentalarithmetic.domain.type.operator.Operator;

import java.util.EnumSet;
import java.util.Optional;

/**
 * 難易度
 */
public enum Level {
    Easy("-e") {
        @Override
        public Expression 左辺() {
            return new TwoLengthExpression(SingleDigitInteger.random(), Operator.random(), SingleDigitInteger.random());
        }

        @Override
        public Expression 右辺() {
            return new TwoLengthExpression(SingleDigitInteger.random(), Operator.random(), SingleDigitInteger.random());
        }
    }, Normal("-n") {
        @Override
        public Expression 左辺() {
            return new TwoLengthExpression(TwoDigitInteger.random(), Operator.random(), TwoDigitInteger.random());
        }

        @Override
        public Expression 右辺() {
            return new TwoLengthExpression(TwoDigitInteger.random(), Operator.random(), TwoDigitInteger.random());
        }
    }, Hard("-h") {
        @Override
        public Expression 左辺() {
            return new ThreeLengthExpression(
                    ThreeDigitInteger.random(),
                    Operator.random(),
                    ThreeDigitInteger.random(),
                    Operator.random(),
                    ThreeDigitInteger.random());
        }

        @Override
        public Expression 右辺() {
            return new ThreeLengthExpression(
                    ThreeDigitInteger.random(),
                    Operator.random(),
                    ThreeDigitInteger.random(),
                    Operator.random(),
                    ThreeDigitInteger.random());
        }
    };

    String parameter;

    Level(String parameter) {
        this.parameter = parameter;
    }

    public abstract Expression 左辺();
    public abstract Expression 右辺();

    public static Optional<Level> レベル取得(String[] 入力されたパラメータ) {
        if (入力されたパラメータ.length <= 0) {
            return Optional.of(Level.Normal);
        }

        return EnumSet.allOf(Level.class).stream()
                .filter(候補 -> 候補.parameter.contains(入力されたパラメータ[0]))
                .findFirst();
    }
}
