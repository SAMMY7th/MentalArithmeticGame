package net.nocono.mentalarithmetic.domain.model.result;

import net.nocono.mentalarithmetic.domain.type.MilliSeconds;

/**
 * 結果
 */
public class Result {
    CorrectResult 正解か不正解か;
    MilliSeconds 解答までにかかったミリ秒数;

    public Result(CorrectResult 正解か不正解か, MilliSeconds 解答までにかかった秒数) {
        this.正解か不正解か = 正解か不正解か;
        this.解答までにかかったミリ秒数 = 解答までにかかった秒数;
    }

    @Override
    public String toString() {
        return this.正解か不正解か + "(" + this.解答までにかかったミリ秒数.秒() + "秒)";
    }
}
