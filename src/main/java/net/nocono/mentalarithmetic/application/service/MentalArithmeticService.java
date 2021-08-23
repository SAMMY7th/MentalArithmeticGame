package net.nocono.mentalarithmetic.application.service;

import net.nocono.mentalarithmetic.domain.model.Level;
import net.nocono.mentalarithmetic.domain.model.Question;
import net.nocono.mentalarithmetic.domain.model.QuestionGenerator;
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
}
