package net.nocono.mentalarithmetic.domain.model.result;

import net.nocono.mentalarithmetic.domain.type.MilliSeconds;

/**
 * 結果
 */
public class Result {
    CorrectResult 正解か不正解か;
    MilliSeconds 解答時間;

    public Result(CorrectResult 正解か不正解か, MilliSeconds 解答時間) {
        this.正解か不正解か = 正解か不正解か;
        this.解答時間 = 解答時間;
    }

    @Override
    public String toString() {
        return this.正解か不正解か + "(" + this.解答時間.秒() + "秒)";
    }
}
