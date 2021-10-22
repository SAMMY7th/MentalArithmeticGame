package net.nocono.mentalarithmetic.application.service;

import net.nocono.mentalarithmetic.domain.model.answer.Answer;
import net.nocono.mentalarithmetic.domain.model.level.Level;
import net.nocono.mentalarithmetic.domain.model.question.Question;
import net.nocono.mentalarithmetic.domain.model.result.CorrectResult;
import org.springframework.stereotype.Service;

/**
 * 暗算ゲームサービス
 */
@Service
public class MentalArithmeticService {

    public Question 出題する(Level level) {
        return Question.generate(level);
    }

    public CorrectResult ユーザーの解答の正誤を判定する(Question 問題, Answer 解答) {
        return 問題.正誤判定(解答);
    }
}
