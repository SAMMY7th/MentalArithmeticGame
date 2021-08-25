package net.nocono.mentalarithmetic;

import net.nocono.mentalarithmetic.application.service.MentalArithmeticService;
import net.nocono.mentalarithmetic.domain.model.*;
import net.nocono.mentalarithmetic.domain.type.MilliSeconds;
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
        Optional<Level> level = Level.レベル取得(argStrs);
        if (level.isEmpty()) {
            System.out.println("パラメータが不正です。");
            return;
        }

        Question 問題 = mentalArithmeticService.出題する(level.get());
        LocalDateTime 出題日時 = LocalDateTime.now();

        System.out.println(問題.toString());

        Scanner scanner = new Scanner(System.in);
        String ユーザーの入力 = scanner.next();
        LocalDateTime 解答日時 = LocalDateTime.now();

        Optional<Answer> ユーザーの解答 = Answer.入力文字から変換(ユーザーの入力);
        ユーザーの解答.ifPresentOrElse(解答 -> {
            CorrectResult 正誤 = mentalArithmeticService.入力された解答の正誤を判定する(問題, 解答);
            Result 結果 = new Result(正誤, MilliSeconds.from(出題日時, 解答日時));
            System.out.println(問題.計算式を計算した状態での比較式());
            System.out.println(結果);
        }, () -> System.out.println("入力が正しくありません。"));

        scanner.close();
    }
}
