package net.nocono.mentalarithmetic.domain.model;

/**
 * 演算子
 */
public enum Operator {
    足す("+"),
    引く("-"),
    掛ける("*"),
    割る("/");

    String operator;

    Operator(String operator) {
        this.operator = operator;
    }
}
