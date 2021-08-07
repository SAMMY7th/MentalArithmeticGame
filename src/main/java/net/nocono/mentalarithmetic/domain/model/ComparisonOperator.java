package net.nocono.mentalarithmetic.domain.model;

/**
 * 比較演算子
 */
public enum ComparisonOperator {
    イコール("="),
    以上("<="),
    より大きい("<"),
    以下(">="),
    より小さい(">");

    String operator;

    ComparisonOperator(String operator) {
        this.operator = operator;
    }
}
