package net.nocono.mentalarithmetic.domain.model.expression.token;

/**
 * 優先順位
 */
public class Priority {
    int value;

    Priority(int value) {
        this.value = value;
    }

    private int value() {
        return value;
    }

    public boolean の方がターゲットより優先順位が高い(Priority target) {
        // 数値が小さい方が優先順位が高い
        return this.value < target.value();
    }
}
