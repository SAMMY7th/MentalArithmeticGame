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

    public Question generateQuestion(Level level) {
        QuestionGenerator 質問生成 = new QuestionGenerator(level);
        return 質問生成.generate();
    }
}
