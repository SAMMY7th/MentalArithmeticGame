package net.nocono.mentalarithmetic.domain.model.question;

import net.nocono.mentalarithmetic.domain.model.expression.Expression;
import net.nocono.mentalarithmetic.domain.model.level.Level;
import net.nocono.mentalarithmetic.domain.type.operator.ComparisonOperator;

/**
 * 質問生成
 */
public class QuestionGenerator {
    Level level;

    public QuestionGenerator(Level level) {
        this.level = level;
    }

    public Question generate() {
        ComparisonOperator 比較演算子 = ComparisonOperator.random();
        Expression 左辺 = Expression.generate(level);
        Expression 右辺 = Expression.generate(level);
        return new Question(左辺, 比較演算子, 右辺);
    }
}
