package net.nocono.mentalarithmetic.domain.model.result;

import net.nocono.mentalarithmetic.domain.type.MilliSeconds;

import java.time.LocalDateTime;

/**
 * 解答時間
 */
public class AnswerTime {
    MilliSeconds 解答時間;

    public AnswerTime(MilliSeconds 解答時間) {
        this.解答時間 = 解答時間;
    }

    public static AnswerTime from(LocalDateTime 出題日時, LocalDateTime 解答日時) {
        return new AnswerTime(MilliSeconds.from(出題日時, 解答日時));
    }

    public MilliSeconds 秒() {
        return 解答時間;
    }
}
