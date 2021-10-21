package net.nocono.mentalarithmetic.domain.model.expression;

/**
 * 式の長さ
 */
public enum ExpressionLength {
    数字2個(2),
    数字3個(3);

    int 長さ;

    ExpressionLength(int 長さ) {
        this.長さ = 長さ;
    }
}
