package net.nocono.mentalarithmetic.domain.model.result;

import net.nocono.mentalarithmetic.domain.type.MilliSeconds;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerTimeTest {
    @Test
    void 解答にかかった秒数を表示することができる() {
        LocalDateTime from = LocalDateTime.from(LocalDateTime.parse("2007-12-03T10:15:30"));
        LocalDateTime to = LocalDateTime.from(LocalDateTime.parse("2007-12-03T10:15:33"));
        AnswerTime answerTime = new AnswerTime(MilliSeconds.from(from, to));

        assertEquals("3.0秒", answerTime.toString());
    }
}