package net.nocono.mentalarithmetic.domain.model;

/**
 * 質問生成
 */
public class QuestionGenerator {
    Level level;

    QuestionGenerator(Level level) {
        this.level = level;
    }

    Question generate() {
        Expression 左辺 = null; // TODO: 実装する
        ComparisonOperator 比較演算子 = ComparisonOperator.random();
        Expression 右辺 = null; // TODO: 実装する

        return new Question(左辺, 比較演算子, 右辺);
    }
}
