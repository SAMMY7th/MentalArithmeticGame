package net.nocono.mentalarithmetic.domain.model.expression.token;

import java.util.Random;

/**
 * 比較演算子
 */
public enum ComparisonOperator {
    イコール("=") {
        public boolean apply(double value1, double value2) { return value1 == value2; }
    },
    以上("<=") {
        public boolean apply(double value1, double value2) { return value1 <= value2; }
    },
    より大きい("<") {
        public boolean apply(double value1, double value2) { return value1 < value2; }
    },
    以下(">=") {
        public boolean apply(double value1, double value2) { return value1 >= value2; }
    },
    より小さい(">") {
        public boolean apply(double value1, double value2) { return value1 > value2; }
    };

    String operator;

    public abstract boolean apply(double value1, double value2);
    static Random random = new Random();

    ComparisonOperator(String operator) {
        this.operator = operator;
    }

    public static ComparisonOperator random() {
        int nextInt = random.nextInt(5);

        switch (nextInt) {
            case 0: return ComparisonOperator.イコール;
            case 1: return ComparisonOperator.以上;
            case 2: return ComparisonOperator.より大きい;
            case 3: return ComparisonOperator.以下;
            case 4: return ComparisonOperator.より小さい;
            default: return ComparisonOperator.イコール;
        }
    }

    @Override
    public String toString() {
        return this.operator;
    }
}
