package net.nocono.mentalarithmetic.domain.model.expression;

import net.nocono.mentalarithmetic.domain.model.level.Level;
import net.nocono.mentalarithmetic.domain.type.Token;
import net.nocono.mentalarithmetic.domain.type.digit.DigitInteger;
import net.nocono.mentalarithmetic.domain.type.operator.Operator;

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

    public static Expression generate(Level level) {
        Expression 式 = new Expression(level.式の長さ().式生成(level.桁数()));

        while (式.ゼロ除算発生()) {
            式 = new Expression(level.式の長さ().式生成(level.桁数()));
        }

        return 式;
    }

    public CalculationResult 計算結果() {
        LinkedList<Double> stack = new LinkedList<>();
        for (Token token: 後置記法の式) {
            if (token instanceof DigitInteger 数値) {
                stack.add(数値.toDouble());
            } else if (token instanceof Operator 演算子) {
                double 計算結果 = 演算子.apply(stack.removeLast(), stack.removeLast());
                stack.add(計算結果);
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
        // TODO:
        return "";
    }
}
