package net.nocono.mentalarithmetic.domain.model.expression.token;

import java.util.Random;

/**
 * 演算子
 */
public enum Operator implements Token {
    足す("+") {
        public double apply(double value1, double value2) { return value1 + value2; }
    },
    引く("-") {
        public double apply(double value1, double value2) { return value1 - value2; }
    },
    掛ける("*") {
        public double apply(double value1, double value2) { return value1 * value2; }
    },
    割る("/") {
        public double apply(double value1, double value2) { return value1 / value2; }
    };

    String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public abstract double apply(double value1, double value2);

    static Random random = new Random();

    public static Operator random() {
        int nextInt = random.nextInt(4);

        switch (nextInt) {
            case 0: return Operator.足す;
            case 1: return Operator.引く;
            case 2: return Operator.掛ける;
            case 3: return Operator.割る;
            default: return Operator.足す;
        }
    }

    @Override
    public String toString() {
        return this.operator;
    }
}
