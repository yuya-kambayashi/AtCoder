package org.example.tessokubook;

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
public class A21 {

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
//public class Main {

    // https://atcoder.jp/contests/tessoku-book/submissions/49245643

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[] pp = new int[n + 2];
        int[] aa = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            pp[i] = sc.nextInt();
            aa[i] = sc.nextInt();
        }
        int[][] dp = new int[n + 2][n + 2];

        for (int l = 1; l <= n; l++) {
            for (int r = n; r >= l; r--) {
                int left = dp[l - 1][r];
                if (l <= pp[l - 1] && pp[l - 1] <= r) {
                    left += aa[l - 1];
                }

                int right = dp[l][r + 1];
                if (l <= pp[r + 1] && pp[r + 1] <= r) {
                    right += aa[r + 1];
                }
                dp[l][r] = Math.max(left, right);
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i][i]);
        }

        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        String input = """
                4
                4 20
                3 30
                2 40
                1 10
                
                """;

        String expected = """
                60
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A21.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                8
                8 100
                7 100
                6 100
                5 100
                4 100
                3 100
                2 100
                1 100
                
                """;

        String expected = """
                400
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A21.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A21.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A21.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
