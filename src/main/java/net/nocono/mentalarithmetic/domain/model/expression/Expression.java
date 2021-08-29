package net.nocono.mentalarithmetic.domain.model.expression;

/**
 * 数式
 */
public interface Expression {
    CalculationResult 計算結果();

    boolean ゼロ除算発生();
}
