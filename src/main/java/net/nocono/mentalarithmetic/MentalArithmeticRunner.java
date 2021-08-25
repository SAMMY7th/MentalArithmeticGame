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
        String[] argStrs = args.getSourceArgs();
        Level level;
        if (argStrs.length <= 0) {
            level = Level.Normal;
        } else {
            Optional<Level> 指定のレベル = Level.パラメータから変換(argStrs[0]);
            if (指定のレベル.isEmpty()) {
                System.out.println("パラメータが不正です。");
                return;
            }

            level = 指定のレベル.get();
        }

        Question 問題 = mentalArithmeticService.出題する(level);

        System.out.println(問題.toString());

        Scanner scanner = new Scanner(System.in);
        String ユーザーの入力 = scanner.next();

        Optional<Answer> ユーザーの解答 = Answer.入力文字から変換(ユーザーの入力);
        ユーザーの解答.ifPresentOrElse(解答 -> {
            Result 結果 = mentalArithmeticService.入力された解答の正誤を判定する(問題, 解答);
            System.out.println(結果);
        }, () -> System.out.println("入力が正しくありません。"));
    }
}
