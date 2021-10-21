package net.nocono.mentalarithmetic.domain.model.level;

import net.nocono.mentalarithmetic.domain.model.expression.token.DigitLength;
import net.nocono.mentalarithmetic.domain.model.expression.ExpressionLength;

import java.util.EnumSet;
import java.util.Optional;

/**
 * 難易度
 */
public enum Level {
    Easy("-e", DigitLength.一桁, ExpressionLength.数字2個),
    Normal("-n", DigitLength.二桁, ExpressionLength.数字2個),
    Hard("-h", DigitLength.三桁, ExpressionLength.数字3個);

    String parameter;
    DigitLength 桁数;
    ExpressionLength 式の長さ;

    Level(String parameter, DigitLength 桁数, ExpressionLength 式の長さ) {
        this.parameter = parameter;
        this.桁数 = 桁数;
        this.式の長さ = 式の長さ;
    }

    public static Optional<Level> from(String[] 入力されたパラメータ) {
        if (入力されたパラメータ.length <= 0) {
            return Optional.of(Level.Normal);
        }

        return EnumSet.allOf(Level.class).stream()
                .filter(候補 -> 候補.parameter.contains(入力されたパラメータ[0]))
                .findFirst();
    }

    public DigitLength 桁数() {
        return 桁数;
    }

    public ExpressionLength 式の長さ() {
        return 式の長さ;
    }
}
