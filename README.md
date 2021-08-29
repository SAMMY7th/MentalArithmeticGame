# 暗算脳トレゲーム

アプリを起動すると

```
76+72 >= 32-64
y or n
```
のように問題が表示されます。
正しい式である場合は `y`、誤った式である場合は `n` を入力してください。

正解かどうかと、解答までにかかった秒数が表示されます。

## 起動方法

jarファイルを生成して `java` コマンドで実行。

```shell
./gradlew clean build
```

で `./build/libs/` にjarファイルが生成されます。

コマンド例:

```shell
java -jar ./build/libs/MentalArithmeticGame-1.0-SNAPSHOT.jar
```

オプションで難易度を指定することができます。（省略時はNormal）
-e:Easy -n:Normal -h:Hard

## 設計方針

このアプリの設計は下記の「ドメインオブジェクトの設計パターン」に基づいています。

ドメインオブジェクトの設計パターン: [設計ガイドライン · masuda220/business-logic-patterns Wiki](https://github.com/masuda220/business-logic-patterns/wiki/%E8%A8%AD%E8%A8%88%E3%82%AC%E3%82%A4%E3%83%89%E3%83%A9%E3%82%A4%E3%83%B3)

JIGというコードから一覧や図を生成するツールで設計を可視化することができます。

[dddjava/jig: Java Instant-document Gazer](https://github.com/dddjava/jig)

JIGの利用方法は下記ページを参考にしてください。

[jig/jig-gradle-plugin at main · dddjava/jig](https://github.com/dddjava/jig/tree/main/jig-gradle-plugin)

最新のJIGの図は [こちらのページ](https://github.com/SAMMY7th/MentalArithmeticGame) で見ることができます。
