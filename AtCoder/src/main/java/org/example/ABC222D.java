package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC222D {

    final private StandardInputSnatcher in = new StandardInputSnatcher();
    final private StandardOutputSnatcher out = new StandardOutputSnatcher();

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

    // https://atcoder.jp/contests/abc222/submissions/61346931

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mod = 998244353;

        final int n = sc.nextInt();
        int[] aa = new int[n + 1];
        int[] bb = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            aa[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            bb[i] = sc.nextInt();
        }

        int maxi = bb[n];
        int[][] sum = new int[n + 1][maxi + 1];
        int[][] dp = new int[n + 1][maxi + 1];
        dp[0][0] = 1;

        for (int j = 0; j <= maxi; j++) {
            sum[0][j] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= maxi; j++) {
                if (aa[i] <= j && j <= bb[i]) {
                    dp[i][j] = sum[i - 1][j] % mod;
                }

                sum[i][j] = ((j > 0) ? sum[i][j - 1] : 0) + dp[i][j];
                sum[i][j] %= mod;
            }
        }

        System.out.println(sum[n][maxi]);
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       2
                1 1
                2 3
                """;

        String expected = """
                5
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC222D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       3
                2 2 2
                2 2 2
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC222D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       10
                1 2 3 4 5 6 7 8 9 10
                1 4 9 16 25 36 49 64 81 100
                """;

        String expected = """
                978222082
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC222D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC222D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
