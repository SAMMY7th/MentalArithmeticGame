package net.nocono.mentalarithmetic.domain.model.result;

import net.nocono.mentalarithmetic.domain.model.answer.Answer;
import net.nocono.mentalarithmetic.domain.model.question.Question;

/**
 * 正解か不正解か
 */
public enum CorrectResult {
    正解, 不正解;

    public static CorrectResult 正誤判定(Question 問題, Answer ユーザーの解答) {
        if(ユーザーの解答 == Answer.正解(問題)) return CorrectResult.正解;
        return CorrectResult.不正解;
    }
}
