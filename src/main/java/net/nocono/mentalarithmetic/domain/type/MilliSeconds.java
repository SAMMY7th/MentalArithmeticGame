package net.nocono.mentalarithmetic.domain.type;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * ミリ秒
 */
public class MilliSeconds {
    int value;

    public MilliSeconds(int value) {
        this.value = value;
    }

    public static MilliSeconds from(LocalDateTime from, LocalDateTime to) {
        return MilliSeconds.valueOf((int) ChronoUnit.MILLIS.between(from, to));
    }

    private static MilliSeconds valueOf(int value) {
        return new MilliSeconds(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public float 秒() {
        return (float) this.value / 1000;
    }
}
