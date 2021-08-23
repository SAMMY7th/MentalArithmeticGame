package net.nocono.mentalarithmetic;

import net.nocono.mentalarithmetic.application.service.MentalArithmeticService;
import net.nocono.mentalarithmetic.domain.model.Answer;
import net.nocono.mentalarithmetic.domain.model.Level;
import net.nocono.mentalarithmetic.domain.model.Question;
import net.nocono.mentalarithmetic.domain.model.Result;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class MentalArithmeticRunner implements ApplicationRunner {
    MentalArithmeticService mentalArithmeticService;

    public MentalArithmeticRunner(MentalArithmeticService mentalArithmeticService) {
        this.mentalArithmeticService = mentalArithmeticService;
    }

    /**
     * 実行
     * @param args レベル -e(Easy), -n(Normal), -h(Hard) 未指定時はNormal
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Question 問題 = mentalArithmeticService.出題する(Level.Normal);// TODO: 引数から受け取るようにする

        System.out.println(問題.toString());

        Scanner scanner = new Scanner(System.in);
        String ユーザーの入力 = scanner.next();

        Optional<Answer> ユーザーの解答 = Answer.入力文字から変換(ユーザーの入力);
        ユーザーの解答.ifPresentOrElse(解答 -> {
            Result 結果 = 問題.判定(解答);
            System.out.println(結果);
        }, () -> System.out.println("入力が正しくありません。"));
    }
}
