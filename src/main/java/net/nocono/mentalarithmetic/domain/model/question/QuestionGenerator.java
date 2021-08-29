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
        Expression 左辺 = level.左辺();
        ComparisonOperator 比較演算子 = ComparisonOperator.random();
        Expression 右辺 = level.右辺();

        while (左辺.ゼロ除算発生()) {
            左辺 = level.左辺();
        }

        while (右辺.ゼロ除算発生()) {
            右辺 = level.右辺();
        }

        return new Question(左辺, 比較演算子, 右辺);
    }
}
