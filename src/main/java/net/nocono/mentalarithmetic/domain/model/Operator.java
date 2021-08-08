package net.nocono.mentalarithmetic.domain.model;

import java.util.Random;

/**
 * 演算子
 */
public enum Operator {
    足す("+", new Priority(2)) {
        public double apply(double value1, double value2) { return value1 + value2; }
    },
    引く("-", new Priority(2)) {
        public double apply(double value1, double value2) { return value1 - value2; }
    },
    掛ける("*", new Priority(1)) {
        public double apply(double value1, double value2) { return value1 * value2; }
    },
    割る("/", new Priority(1)) {
        public double apply(double value1, double value2) { return value1 / value2; }
    };

    String operator;
    Priority priority;

    Operator(String operator, Priority priority) {
        this.operator = operator;
        this.priority = priority;
    }

    public abstract double apply(double value1, double value2);

    static Random random = new Random();

    public boolean の方がターゲットより優先順位が高い(Operator target) {
        return this.priority.の方がターゲットより優先順位が高い(target.priority);
    }

    static Operator random() {
        int nextInt = random.nextInt(4);

        switch (nextInt) {
            case 0: return Operator.足す;
            case 1: return Operator.引く;
            case 2: return Operator.掛ける;
            case 3: return Operator.割る;
            default: return Operator.足す;
        }
    }
}
