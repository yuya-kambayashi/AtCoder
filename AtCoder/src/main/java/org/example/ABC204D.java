package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC204D {

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

    // https://atcoder.jp/contests/abc204/submissions/56509163
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[] tt = new int[n];
        int sumt = 0;
        for (int i = 0; i < n; i++) {
            tt[i] = sc.nextInt();
            sumt += tt[i];
        }

        boolean[][] dp = new boolean[n][sumt + 1];
        dp[0][0] = true;
        dp[0][tt[0]] = true;

        int sum = tt[0];

        for (int i = 1; i < n; i++) {
            sum += tt[i];
            for (int j = 0; j <= sum; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                    dp[i][j + tt[i]] = true;
                }
            }
        }
        for (int i = (sumt + 1) / 2; i <= sumt; i++) {
            if (dp[n - 1][i]) {
                System.out.println(i);
                return;
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       5
                8 3 7 2 5
                """;

        String expected = """
                13
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC204D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       2
                1000 1
                """;

        String expected = """
                1000
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC204D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       9
                3 14 15 9 26 5 35 89 79
                """;

        String expected = """
                138
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC204D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC204D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
