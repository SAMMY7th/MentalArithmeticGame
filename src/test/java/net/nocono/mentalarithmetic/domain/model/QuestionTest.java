package net.nocono.mentalarithmetic.domain.model;

import net.nocono.mentalarithmetic.domain.model.answer.Answer;
import net.nocono.mentalarithmetic.domain.model.expression.Expression;
import net.nocono.mentalarithmetic.domain.model.expression.TwoLengthTwoDigitExpression;
import net.nocono.mentalarithmetic.domain.model.question.Question;
import net.nocono.mentalarithmetic.domain.type.operator.ComparisonOperator;
import net.nocono.mentalarithmetic.domain.type.operator.Operator;
import net.nocono.mentalarithmetic.domain.type.digit.SingleDigitInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void 問題の正解を取得することができる１() {
        Expression 左辺 = new TwoLengthTwoDigitExpression(SingleDigitInteger.valueOf(1), Operator.足す, SingleDigitInteger.valueOf(2));
        ComparisonOperator 比較演算子 = ComparisonOperator.イコール;
        Expression 右辺 = new TwoLengthTwoDigitExpression(SingleDigitInteger.valueOf(1), Operator.引く, SingleDigitInteger.valueOf(2));

        Question question = new Question(左辺, 比較演算子, 右辺);

        assertEquals(Answer.バツ, question.正解());
    }

    @Test
    void 問題の正解を取得することができる２() {
        Expression 左辺 = new TwoLengthTwoDigitExpression(SingleDigitInteger.valueOf(1), Operator.足す, SingleDigitInteger.valueOf(2));
        ComparisonOperator 比較演算子 = ComparisonOperator.以上;
        Expression 右辺 = new TwoLengthTwoDigitExpression(SingleDigitInteger.valueOf(1), Operator.引く, SingleDigitInteger.valueOf(2));

        Question question = new Question(左辺, 比較演算子, 右辺);

        assertEquals(Answer.バツ, question.正解());
    }

    @Test
    void 問題の正解を取得することができる３() {
        Expression 左辺 = new TwoLengthTwoDigitExpression(SingleDigitInteger.valueOf(1), Operator.足す, SingleDigitInteger.valueOf(2));
        ComparisonOperator 比較演算子 = ComparisonOperator.より大きい;
        Expression 右辺 = new TwoLengthTwoDigitExpression(SingleDigitInteger.valueOf(1), Operator.引く, SingleDigitInteger.valueOf(2));

        Question question = new Question(左辺, 比較演算子, 右辺);

        assertEquals(Answer.バツ, question.正解());
    }

    @Test
    void 問題の正解を取得することができる4() {
        Expression 左辺 = new TwoLengthTwoDigitExpression(SingleDigitInteger.valueOf(1), Operator.足す, SingleDigitInteger.valueOf(2));
        ComparisonOperator 比較演算子 = ComparisonOperator.以下;
        Expression 右辺 = new TwoLengthTwoDigitExpression(SingleDigitInteger.valueOf(1), Operator.引く, SingleDigitInteger.valueOf(2));

        Question question = new Question(左辺, 比較演算子, 右辺);

        assertEquals(Answer.マル, question.正解());
    }

    @Test
    void 問題の正解を取得することができる５() {
        Expression 左辺 = new TwoLengthTwoDigitExpression(SingleDigitInteger.valueOf(1), Operator.足す, SingleDigitInteger.valueOf(2));
        ComparisonOperator 比較演算子 = ComparisonOperator.より小さい;
        Expression 右辺 = new TwoLengthTwoDigitExpression(SingleDigitInteger.valueOf(1), Operator.引く, SingleDigitInteger.valueOf(2));

        Question question = new Question(左辺, 比較演算子, 右辺);

        assertEquals(Answer.マル, question.正解());
    }

}