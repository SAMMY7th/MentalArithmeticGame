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

    @Override
    public String toString() {
        return 左辺.toString() + " " + 比較演算子.toString() + " " + 右辺.toString();
    }

    public String 計算結果() {
        return 左辺.計算結果().toString() + " " + 比較演算子.toString() + " " + 右辺.計算結果().toString();
    }

    public Expression 左辺() {
        return 左辺;
    }

    public ComparisonOperator 比較演算子() {
        return 比較演算子;
    }

    public Expression 右辺() {
        return 右辺;
    }
}
