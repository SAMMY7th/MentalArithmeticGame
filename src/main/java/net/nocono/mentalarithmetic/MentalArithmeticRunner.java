package net.nocono.mentalarithmetic;

import net.nocono.mentalarithmetic.application.service.MentalArithmeticService;
import net.nocono.mentalarithmetic.domain.model.answer.Answer;
import net.nocono.mentalarithmetic.domain.model.level.Level;
import net.nocono.mentalarithmetic.domain.model.question.Question;
import net.nocono.mentalarithmetic.domain.model.result.AnswerTime;
import net.nocono.mentalarithmetic.domain.model.result.CorrectResult;
import net.nocono.mentalarithmetic.domain.model.result.Result;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
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

        if (argStrs.length > 0 && argStrs[0].equals("--help")) {
            ヘルプ表示();
            return;
        }

        Optional<Level> level = Level.from(argStrs);
        if (level.isEmpty()) {
            System.out.println("パラメータが不正です。");
            return;
        }

        Question 問題 = mentalArithmeticService.出題する(level.get());
        LocalDateTime 出題日時 = LocalDateTime.now();

        System.out.println(問題.toString());
        System.out.println("y or n");

        Scanner scanner = new Scanner(System.in);
        LocalDateTime 解答日時 = LocalDateTime.now();
        Answer.from(scanner.next()).ifPresentOrElse(ユーザーの解答 -> {
            CorrectResult 正誤 = mentalArithmeticService.ユーザーの解答の正誤を判定する(問題, ユーザーの解答);
            AnswerTime 解答時間 = AnswerTime.from(出題日時, 解答日時);

            Result 結果 = new Result(正誤, 解答時間);

            System.out.println(問題.計算結果());
            System.out.println(結果);
        }, () -> System.out.println("入力が正しくありません。"));

        scanner.close();
    }

    private void ヘルプ表示() {
        System.out.println("-e:Easy -n:Normal -h:Hard");
    }
}
