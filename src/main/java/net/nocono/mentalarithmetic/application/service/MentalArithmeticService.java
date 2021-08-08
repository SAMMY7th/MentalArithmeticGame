package net.nocono.mentalarithmetic.application.service;

import net.nocono.mentalarithmetic.domain.model.Level;
import net.nocono.mentalarithmetic.domain.model.Question;
import net.nocono.mentalarithmetic.domain.model.QuestionGenerator;

/**
 * 暗算ゲームサービス
 */
public class MentalArithmeticService {

    public Question 暗算ゲームの問題を取得する() {
        QuestionGenerator 質問生成 = new QuestionGenerator(Level.Easy);
        return 質問生成.generate();
    }
}
