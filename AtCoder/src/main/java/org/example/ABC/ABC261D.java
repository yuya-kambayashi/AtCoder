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
public class ABC261D {

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

    // https://atcoder.jp/contests/abc261/submissions/33481990

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        int[] xx = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            xx[i] = sc.nextInt();
        }
        int[] cy = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int c = sc.nextInt();
            int y = sc.nextInt();
            cy[c] = y;
        }

        long[][] dp = new long[n + 2][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + xx[i] + cy[j];
                dp[i + 1][0] = Math.max(dp[i + 1][0], dp[i][j]);
            }
        }

        System.out.println(dp[n + 1][0]);
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       6 3
                2 7 1 8 2 8
                2 10
                3 1
                5 5
                """;

        String expected = """
                48
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC261D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       3 2
                1000000000 1000000000 1000000000
                1 1000000000
                3 1000000000
                """;

        String expected = """
                5000000000
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC261D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC261D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC261D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
