package net.nocono.mentalarithmetic.domain.model;

/**
 * 問題
 */
public class Question {
    Expression 左辺;
    ComparisonOperator 比較演算子;
    Expression 右辺;

    public Question(Expression 左辺, ComparisonOperator 比較演算子, Expression 右辺) {
        this.左辺 = 左辺;
        this.比較演算子 = 比較演算子;
        this.右辺 = 右辺;
    }

    Answer 正解() {
        boolean 真偽 = 比較演算子.apply(左辺.計算結果().value, 右辺.計算結果().value);
        if(真偽) return Answer.まる;

        return Answer.ばつ;
    }

    @Override
    public String toString() {
        return 左辺.toString() + " " + 比較演算子.toString() + " " + 右辺.toString();
    }

    public Result 判定(Answer ユーザーの解答) {
        if(ユーザーの解答 == 正解()) return Result.正解;
        return Result.不正解;
    }
}
