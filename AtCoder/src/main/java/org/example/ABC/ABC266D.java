package org.example.ABC;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.template.StandardInputSnatcher;
import org.example.template.StandardOutputSnatcher;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC266D {

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

    // https://atcoder.jp/contests/abc266/submissions/34381063

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[][] snukes = new int[100010][5];
        long[][] dp = new long[100010][5];
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            int a = sc.nextInt();
            if (x <= t) {
                snukes[t][x] = a;
            }
        }
        for (int i = 1; i < 100010; i++) {
            for (int j = 0; j < 5; j++) {
                dp[i][j] = dp[i - 1][j] + snukes[i][j];
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + snukes[i][j]);
                }
                if (j < 4) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + snukes[i][j]);
                }
            }
        }

        System.out.println(dp[100009][0]);
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       3
                1 0 100
                3 3 10
                5 4 1
                """;

        String expected = """
                101
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC266D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       3
                1 4 1
                2 4 1
                3 4 1
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC266D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       10
                1 4 602436426
                2 1 623690081
                3 3 262703497
                4 4 628894325
                5 3 450968417
                6 1 161735902
                7 1 707723857
                8 2 802329211
                9 0 317063340
                10 2 125660016
                """;

        String expected = """
                2978279323
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC266D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC266D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
