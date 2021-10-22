package net.nocono.mentalarithmetic.domain.model.expression;

import net.nocono.mentalarithmetic.domain.model.expression.token.DigitInteger;
import net.nocono.mentalarithmetic.domain.model.expression.token.DigitLength;
import net.nocono.mentalarithmetic.domain.model.expression.token.Operator;
import net.nocono.mentalarithmetic.domain.model.expression.token.Token;

import java.util.LinkedList;
import java.util.List;

/**
 * 数式
 */
public class Expression {
    List<Token> 後置記法の式;

    public Expression(List<Token> 後置記法の式) {
        this.後置記法の式 = 後置記法の式;
    }

    public static Expression generate(DigitLength 桁数, ExpressionLength 式の長さ) {
        Expression 式 = new Expression(式の長さ.式生成(桁数));

        while (式.ゼロ除算発生()) {
            式 = new Expression(式の長さ.式生成(桁数));
        }

        return 式;
    }

    public CalculationResult 計算結果() {
        LinkedList<Double> stack = new LinkedList<>();
        for (Token token: 後置記法の式) {
            // TODO: JDK17対応
//            if (token instanceof DigitInteger 数値) {
            if (token instanceof DigitInteger) {
                DigitInteger 数値 = (DigitInteger) token;
                stack.add(数値.toDouble());
//            } else if (token instanceof Operator 演算子) {
            } else if (token instanceof Operator) {
                Operator 演算子 = (Operator) token;
                double 数2 = stack.removeLast();
                double 数1 = stack.removeLast();
                stack.add(演算子.apply(数1, 数2));
            }
        }

        return new CalculationResult(stack.removeLast());
    }

    boolean ゼロ除算発生() {
        if (Double.isInfinite(計算結果().value())) return true;

        return false;
    }

    @Override
    public String toString() {
        LinkedList<String> stack = new LinkedList<>();
        for (Token token: 後置記法の式) {
            // TODO: JDK17対応
//            if (token instanceof DigitInteger 数値) {
            if (token instanceof DigitInteger) {
                DigitInteger 数値 = (DigitInteger) token;
                stack.add(数値.toString());
//            } else if (token instanceof Operator 演算子) {
            } else if (token instanceof Operator) {
                Operator 演算子 = (Operator) token;
                String 数字2 = stack.removeLast();
                String 数字1 = stack.removeLast();

                String 式 = 数字1 + 演算子 + 数字2;

                stack.add(式);
            }
        }

        String result = "";
        for (String s: stack) {
            result = result + s;
        }
        return result;
    }
}
