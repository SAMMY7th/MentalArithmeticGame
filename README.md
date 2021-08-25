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


