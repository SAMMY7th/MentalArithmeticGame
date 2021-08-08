package net.nocono.mentalarithmetic.domain.model;

/**
 * 問題
 */
public class Question {
    Expression leftExpression;
    ComparisonOperator comparisonOperator;
    Expression rightExpression;

    public Question(Expression 左辺, ComparisonOperator 比較演算子, Expression 右辺) {
        this.leftExpression = 左辺;
        this.comparisonOperator = 比較演算子;
        this.rightExpression = 右辺;
    }

    Answer 正解() {
        boolean 真偽 = comparisonOperator.apply(leftExpression.計算結果().value, rightExpression.計算結果().value);
        if(真偽) return Answer.まる;

        return Answer.ばつ;
    }

    @Override
    public String toString() {
        return leftExpression.toString() + comparisonOperator.toString() + rightExpression.toString();
    }
}
