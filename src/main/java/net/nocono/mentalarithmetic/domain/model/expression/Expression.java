package net.nocono.mentalarithmetic.domain.model.expression;

import net.nocono.mentalarithmetic.domain.model.expression.token.DigitInteger;
import net.nocono.mentalarithmetic.domain.model.expression.token.DigitLength;
import net.nocono.mentalarithmetic.domain.model.expression.token.Operator;
import net.nocono.mentalarithmetic.domain.model.expression.token.Token;

import java.util.LinkedList;
import java.util.List;

import static net.nocono.mentalarithmetic.domain.model.expression.token.Operator.割る;
import static net.nocono.mentalarithmetic.domain.model.expression.token.Operator.掛ける;

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
        for (int i = 0; i < 後置記法の式.size(); i++) {
            Token token = 後置記法の式.get(i);
            // TODO: JDK17対応
//            if (token instanceof DigitInteger 数値) {
            if (token instanceof DigitInteger) {
                DigitInteger 数値 = (DigitInteger) token;

                // 1個目ではない負の値である場合、括弧をつける
                if (数値.負の値() && !stack.isEmpty()) {
                    stack.add("(" + 数値.toString() + ")");
                } else {
                    stack.add(数値.toString());
                }

//            } else if (token instanceof Operator 演算子) {
            } else if (token instanceof Operator) {
                Operator 演算子 = (Operator) token;
                String 数字2 = stack.removeLast();
                String 数字1 = stack.removeLast();

                String 式 = 数字1 + 演算子 + 数字2;

                // あとに優先度が高い演算子がある場合、括弧をつける
                boolean 括弧有り = false;
                for (int j = i + 1; j < 後置記法の式.size(); j++) {
                    Token token2 = 後置記法の式.get(j);
                    if (token2 instanceof Operator) {
                        if (token2 == 掛ける || token2 == 割る) {
                            括弧有り = true;
                        }
                    }
                }

                if (括弧有り) {
                    stack.add("(" + 式 + ")");
                } else {
                    stack.add(式);
                }
            }
        }

        String result = "";
        for (String s: stack) {
            result = result + s;
        }
        return result;
    }
}
