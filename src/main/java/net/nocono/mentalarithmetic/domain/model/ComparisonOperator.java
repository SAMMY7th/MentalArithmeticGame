package net.nocono.mentalarithmetic.domain.model;

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

    ComparisonOperator(String operator) {
        this.operator = operator;
    }
}
