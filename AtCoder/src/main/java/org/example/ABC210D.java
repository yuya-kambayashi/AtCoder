package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC210D {

    private StandardInputSnatcher in = new StandardInputSnatcher();
    private StandardOutputSnatcher out = new StandardOutputSnatcher();

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

    // https://atcoder.jp/contests/abc210/submissions/56339842
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int h = sc.nextInt();
        final int w = sc.nextInt();
        final long c = sc.nextLong();

        long[][] aa = new long[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                aa[i][j] = sc.nextLong();
            }
        }

        long result = solve(h, w, c, aa);

        System.out.println(result);
    }

    static long solve(int h, int w, long c, long[][] aa) {

        long ans = Long.MAX_VALUE;
        long[][] dp = new long[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                dp[i][j] = aa[i][j];
                if (i > 0) {
                    ans = Math.min(ans, aa[i][j] + dp[i - 1][j] + c);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + c);
                }
                if (j > 0) {
                    ans = Math.min(ans, aa[i][j] + dp[i][j - 1] + c);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + c);
                }
            }
        }
        dp = new long[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = w - 1; j >= 0; j--) {
                dp[i][j] = aa[i][j];
                if (i > 0) {
                    ans = Math.min(ans, aa[i][j] + dp[i - 1][j] + c);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + c);
                }
                if (j < w - 1) {
                    ans = Math.min(ans, aa[i][j] + dp[i][j + 1] + c);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + c);
                }
            }
        }

        return ans;
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       3 4 2
                1 7 7 9
                9 6 3 7
                7 8 6 4
                """;

        String expected = """
                10
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC210D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                                       3 3 1000000000
                1000000 1000000 1
                1000000 1000000 1000000
                1 1000000 1000000
                """;

        String expected = """
                1001000001
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC210D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC210D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC210D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
