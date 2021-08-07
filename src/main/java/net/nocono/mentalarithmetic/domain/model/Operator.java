package net.nocono.mentalarithmetic.domain.model;

/**
 * 演算子
 */
public enum Operator {
    足す("+") {
        public double apply(int value1, int value2) { return (double)value1 + (double)value2; }
    },
    引く("-") {
        public double apply(int value1, int value2) { return (double)value1 - (double)value2; }
    },
    掛ける("*") {
        public double apply(int value1, int value2) { return (double)value1 * (double)value2; }
    },
    割る("/") {
        public double apply(int value1, int value2) { return (double)value1 / (double)value2; }
    };

    String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public abstract double apply(int value1, int value2);
}
