package net.nocono.mentalarithmetic.application.service;

import net.nocono.mentalarithmetic.domain.model.*;
import org.springframework.stereotype.Service;

/**
 * 暗算ゲームサービス
 */
@Service
public class MentalArithmeticService {

    public Question 出題する(Level level) {
        QuestionGenerator 問題生成 = new QuestionGenerator(level);
        return 問題生成.generate();
    }

    public CorrectResult 入力された解答の正誤を判定する(Question 問題, Answer 解答) {
        return 問題.判定(解答);
    }
}
