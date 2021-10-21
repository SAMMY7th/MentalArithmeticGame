package net.nocono.mentalarithmetic.domain.model.level;

import net.nocono.mentalarithmetic.domain.model.expression.Expression;
import net.nocono.mentalarithmetic.domain.model.expression.ThreeLengthThreeDigitExpression;
import net.nocono.mentalarithmetic.domain.model.expression.TwoLengthSingleDigitExpression;
import net.nocono.mentalarithmetic.domain.model.expression.TwoLengthTwoDigitExpression;

import java.util.EnumSet;
import java.util.Optional;

/**
 * 難易度
 */
public enum Level {
    Easy("-e") {
        @Override
        public Expression 左辺() {
            return TwoLengthSingleDigitExpression.generate();
        }

        @Override
        public Expression 右辺() {
            return TwoLengthSingleDigitExpression.generate();
        }
    }, Normal("-n") {
        @Override
        public Expression 左辺() {
            return TwoLengthTwoDigitExpression.generate();
        }

        @Override
        public Expression 右辺() {
            return TwoLengthTwoDigitExpression.generate();
        }
    }, Hard("-h") {
        @Override
        public Expression 左辺() {
            return ThreeLengthThreeDigitExpression.generate();
        }

        @Override
        public Expression 右辺() {
            return ThreeLengthThreeDigitExpression.generate();
        }
    };

    String parameter;

    Level(String parameter) {
        this.parameter = parameter;
    }

    public abstract Expression 左辺();
    public abstract Expression 右辺();

    public static Optional<Level> from(String[] 入力されたパラメータ) {
        if (入力されたパラメータ.length <= 0) {
            return Optional.of(Level.Normal);
        }

        return EnumSet.allOf(Level.class).stream()
                .filter(候補 -> 候補.parameter.contains(入力されたパラメータ[0]))
                .findFirst();
    }
}
