package net.nocono.mentalarithmetic.domain.model;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

/**
 * 解答
 */
public enum Answer {
    まる(List.of("y", "Y")), ばつ(List.of("n", "N"));

    List<String> 入力文字;

    Answer(List<String> 入力文字) {
        this.入力文字 = 入力文字;
    }

    public static Optional<Answer> 入力文字から変換(String 入力された文字) {
        return EnumSet.allOf(Answer.class).stream().filter(解答候補 -> 解答候補.入力文字.contains(入力された文字)).findFirst();
    }
}
