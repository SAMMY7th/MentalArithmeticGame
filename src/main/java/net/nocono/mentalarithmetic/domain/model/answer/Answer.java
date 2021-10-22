package net.nocono.mentalarithmetic.domain.model.answer;

import net.nocono.mentalarithmetic.domain.model.question.Question;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

/**
 * 解答
 */
public enum Answer {
    マル(List.of("y", "Y")), バツ(List.of("n", "N"));

    List<String> 入力文字;

    Answer(List<String> 入力文字) {
        this.入力文字 = 入力文字;
    }

    public static Optional<Answer> from(String 入力された文字) {
        return EnumSet.allOf(Answer.class).stream()
                .filter(解答候補 -> 解答候補.入力文字.contains(入力された文字))
                .findFirst();
    }

    public static Answer 正解(Question 問題) {
        boolean 真偽 = 問題.比較演算子().apply(問題.左辺().計算結果().value(), 問題.右辺().計算結果().value());
        if(真偽) return Answer.マル;

        return Answer.バツ;
    }
}
