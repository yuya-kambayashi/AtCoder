package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC202D {

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

    // https://atcoder.jp/contests/abc202/submissions/55487869
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        long k = sc.nextLong();

        long[][] dp = new long[61][61];
        dp[0][0] = 1;
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 60; j++) {
                dp[i + 1][j] += dp[i][j];
                dp[i + 1][j + 1] += dp[i][j];
            }
        }
        String ans = "";
        while (a + b > 0) {
            long x = 0;
            if (a > 0) {
                x = dp[a + b - 1][a - 1];
            }
            if (k <= x) {
                ans += "a";
                a--;
            } else {
                ans += "b";
                b--;
                k -= x;
            }
        }

        System.out.println(ans);

    }
//}

    @Test
    public void Case1() {

        String input = """
                2 2 4                                             30                          
                """;

        String expected = """
                baab
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC202D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                   30 30 118264581564861424
                """;

        String expected = """
                bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC202D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC202D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC202D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
