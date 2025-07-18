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
public class A16 {

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

    // https://atcoder.jp/contests/tessoku-book/submissions/39798507

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[] aa = new int[n + 1];
        int[] bb = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            aa[i] = sc.nextInt();
        }
        for (int i = 3; i <= n; i++) {
            bb[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        dp[2] = aa[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + aa[i], dp[i - 2] + bb[i]);
        }
        System.out.println(dp[n]);
    }
//}

    @Test
    public void Case1() {

        String input = """
                5
                2 4 1 3
                5 3 7
                
                """;

        String expected = """
                8
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A16.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                10
                1 19 75 37 17 16 33 18 22
                41 28 89 74 98 43 42 31
                
                """;

        String expected = """
                157
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A16.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A16.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A16.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
