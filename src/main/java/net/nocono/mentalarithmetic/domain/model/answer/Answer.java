package net.nocono.mentalarithmetic.domain.model.answer;

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
}
