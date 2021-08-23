package net.nocono.mentalarithmetic.domain.model;

import net.nocono.mentalarithmetic.domain.type.operator.ComparisonOperator;
import net.nocono.mentalarithmetic.domain.type.operator.Operator;
import net.nocono.mentalarithmetic.domain.type.digit.SingleDigitInteger;

/**
 * 質問生成
 */
public class QuestionGenerator {
    Level level;

    public QuestionGenerator(Level level) {
        this.level = level;
    }

    public Question generate() {
        // TODO: レベルに応じた式を生成するようにする
        Expression 左辺 = new TwoLengthExpression(SingleDigitInteger.random(), Operator.random(), SingleDigitInteger.random());
        ComparisonOperator 比較演算子 = ComparisonOperator.random();
        Expression 右辺 = new TwoLengthExpression(SingleDigitInteger.random(), Operator.random(), SingleDigitInteger.random());

        return new Question(左辺, 比較演算子, 右辺);
    }
}
