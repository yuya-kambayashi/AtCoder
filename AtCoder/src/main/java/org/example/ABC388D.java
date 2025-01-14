package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC388D {

    private final StandardInputSnatcher in = new StandardInputSnatcher();
    private final StandardOutputSnatcher out = new StandardOutputSnatcher();

    @BeforeAll
    public void beforeAll() {
        System.setIn(in);
        System.setOut(out);
    }

    @AfterAll
    public void afterAll() {
        System.setIn(null);
        System.setOut(null);
    }
//import java.math.*;
//import java.util.*;
//import java.util.stream.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力を受け取る
        int n = sc.nextInt();
        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }

        // dpの初期化
        int[][] dp = new int[n + 1][n]; // n+1 行, n 列の2次元配列
        for (int i = 0; i < n; i++) {
            dp[0][i] = aa[i]; // dp[0] に aa をコピー
            dp[1][i] = aa[i]; // dp[1] に aa をコピー
        }

        // dpテーブルを更新
        for (int i = 2; i <= n; i++) {
            // iまでの人が成人
            for (int j = 0; j < i - 1; j++) {
                if (dp[i - 1][j] > 0) {
                    dp[i][j] = dp[i - 1][j] - 1;
                    if (i - 1 < n) {  // 配列範囲チェック
                        dp[i][i - 1]++;
                    }
                }
            }

            // dp[i][j] の更新
            for (int j = i - 1; j < n; j++) {
                dp[i][j] += dp[i - 1][j];
            }
        }

        // 結果を出力
        for (int i = 0; i < n; i++) {
            System.out.print(dp[n][i] + " ");
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                4
                5 0 9 3
                
                """;

        String expected = """
                2 0 10 5
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC388D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                5
                4 6 7 2 5
                
                """;

        String expected = """
                0 4 7 4 9
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC388D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                10
                2 9 1 2 0 4 6 7 1 5
                
                """;

        String expected = """
                0 2 0 0 0 4 7 10 4 10
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC388D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                1
                1
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC388D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
