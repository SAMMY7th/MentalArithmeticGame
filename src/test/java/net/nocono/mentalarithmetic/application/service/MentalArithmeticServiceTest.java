package net.nocono.mentalarithmetic.application.service;

import net.nocono.mentalarithmetic.domain.model.Level;
import net.nocono.mentalarithmetic.domain.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes=MentalArithmeticService.class)
class MentalArithmeticServiceTest {

    @Autowired
    MentalArithmeticService mentalArithmeticService;

    @Test
    void 問題を出題することができる() {
        Question 問題 = mentalArithmeticService.出題する(Level.Normal);
        assertNotNull(問題);
    }

    @Test
    void 入力された解答の正誤を判定することができる() {
        // TODO:
    }
}