package net.nocono.mentalarithmetic.domain.model;

/**
 * 数字が２個の数式
 */
public class TwoLengthExpression implements Expression {
    Number number1;
    Operator operator;
    Number number2;

    TwoLengthExpression(Number number1, Operator operator, Number number2) {
        this.number1 = number1;
        this.operator = operator;
        this.number2 = number2;
    }
}
