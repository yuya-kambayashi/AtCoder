package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC262D {

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

    // https://atcoder.jp/contests/abc262/submissions/33683683

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mod = 998244353;

        final int n = sc.nextInt();
        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }
        int ans = 0;
        for (int p = 1; p <= n; p++) {
            int[][][] dp = new int[n + 1][p + 2][p + 1];
            dp[0][0][0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= p; j++) {
                    for (int k = 0; k < p; k++) {
                        dp[i + 1][j][k] += dp[i][j][k];
                        dp[i + 1][j][k] %= mod;
                        dp[i + 1][j + 1][(k + aa[i]) % p] += dp[i][j][k];
                        dp[i + 1][j + 1][(k + aa[i]) % p] %= mod;
                    }
                }
            }
            ans += dp[n][p][0];
            ans %= mod;
        }
        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       3
                2 6 2
                """;

        String expected = """
                6
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC262D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       5
                5 5 5 5 5
                """;

        String expected = """
                31
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC262D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC262D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC262D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}