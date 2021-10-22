package net.nocono.mentalarithmetic.domain.model.question;

import net.nocono.mentalarithmetic.domain.model.level.Level;
import net.nocono.mentalarithmetic.domain.model.result.CorrectResult;
import net.nocono.mentalarithmetic.domain.model.answer.Answer;
import net.nocono.mentalarithmetic.domain.model.expression.Expression;
import net.nocono.mentalarithmetic.domain.model.expression.token.ComparisonOperator;

/**
 * 問題
 */
public class Question {
    Expression 左辺;
    ComparisonOperator 比較演算子;
    Expression 右辺;
    Level level;

    public Question(Expression 左辺, ComparisonOperator 比較演算子, Expression 右辺, Level level) {
        this.左辺 = 左辺;
        this.比較演算子 = 比較演算子;
        this.右辺 = 右辺;
        this.level = level;
    }

    public static Question generate(Level level) {
        ComparisonOperator 比較演算子 = ComparisonOperator.random();
        Expression 左辺 = Expression.generate(level.桁数(), level.式の長さ());
        Expression 右辺 = Expression.generate(level.桁数(), level.式の長さ());
        return new Question(左辺, 比較演算子, 右辺, level);
    }

    public Answer 正解() {
        boolean 真偽 = 比較演算子.apply(左辺.計算結果().value(), 右辺.計算結果().value());
        if(真偽) return Answer.マル;

        return Answer.バツ;
    }

    @Override
    public String toString() {
        return 左辺.toString() + " " + 比較演算子.toString() + " " + 右辺.toString();
    }

    public CorrectResult 正誤判定(Answer ユーザーの解答) {
        if(ユーザーの解答 == 正解()) return CorrectResult.正解;
        return CorrectResult.不正解;
    }

    public String 計算結果() {
        return 左辺.計算結果().toString() + " " + 比較演算子.toString() + " " + 右辺.計算結果().toString();
    }
}
