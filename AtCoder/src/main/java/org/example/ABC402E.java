package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC402E {

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
    static int N, X;
    static int[] S, C, P;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        X = sc.nextInt();
        S = new int[N];
        C = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            S[i] = sc.nextInt();
            C[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        // dp[金額][正解状態bit] = 最大期待値
        double[][] dp = new double[X + 1][1 << N];

        for (int money = 0; money <= X; money++) {
            for (int bit = 0; bit < (1 << N); bit++) {
                for (int i = 0; i < N; i++) {
                    // すでに解いた問題は無視
                    if ((bit & (1 << i)) != 0) continue;
                    int nextMoney = money + C[i];
                    if (nextMoney > X) continue;

                    int nextBitCorrect = bit | (1 << i);
                    double prob = P[i] / 100.0;

                    // 成功時と失敗時の遷移
                    double success = dp[money][bit] + prob * S[i];
                    double expected = success +
                            (1 - prob) * dp[nextMoney][bit];

                    // 遷移先の状態を更新
                    dp[nextMoney][nextBitCorrect] = Math.max(
                            dp[nextMoney][nextBitCorrect],
                            expected
                    );
                }
            }
        }

        // 最終的に使った金額すべての中で最大値をとる
        double result = 0;
        for (int money = 0; money <= X; money++) {
            for (int bit = 0; bit < (1 << N); bit++) {
                result = Math.max(result, dp[money][bit]);
            }
        }

        System.out.printf("%.10f\n", result);
    }
//}

    @Test
    public void Case1() {

        String input = """
                3 2
                100 1 50
                200 1 20
                1000 1 1
                
                """;

        String expected = """
                95
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC402E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                2 7
                100 3 50
                100 2 50
                
                """;

        String expected = """
                125
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC402E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                5 32
                500 9 57
                300 4 8
                300 3 32
                300 7 99
                100 8 69
                
                """;

        String expected = """
                953.976967020096
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC402E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                7 78
                100 1 100
                200 2 90
                300 3 80
                400 4 60
                450 5 50
                525 6 30
                650 7 1
                
                """;

        String expected = """
                1976.2441416041121021
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC402E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
