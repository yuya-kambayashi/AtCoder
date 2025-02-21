package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC291D {

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

    // https://atcoder.jp/contests/abc291/submissions/44583686

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int mod = 998244353;

        final int n = sc.nextInt();
        int[][] cards = new int[2][n + 1];
        long[][] dp = new long[2][n + 1];
        for (int i = 1; i <= n; i++) {
            cards[0][i] = sc.nextInt();
            cards[1][i] = sc.nextInt();
        }
        dp[0][1] = 1;
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            if (cards[0][i] != cards[0][i - 1]) {
                dp[0][i] += dp[0][i - 1];
            }
            if (cards[0][i] != cards[1][i - 1]) {
                dp[0][i] += dp[1][i - 1];
            }
            dp[0][i] %= mod;

            if (cards[1][i] != cards[0][i - 1]) {
                dp[1][i] += dp[0][i - 1];
            }
            if (cards[1][i] != cards[1][i - 1]) {
                dp[1][i] += dp[1][i - 1];
            }
            dp[1][i] %= mod;
        }

        System.out.println((dp[0][n] + dp[1][n]) % mod);
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       3
                1 2
                4 2
                3 4
                """;

        String expected = """
                4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC291D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       4
                1 5
                2 6
                3 7
                4 8
                """;

        String expected = """
                16
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC291D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       8
                877914575 602436426
                861648772 623690081
                476190629 262703497
                971407775 628894325
                822804784 450968417
                161735902 822804784
                161735902 822804784
                822804784 161735902
                """;

        String expected = """
                48
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC291D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC291D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
