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
public class A19 {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int w = sc.nextInt();
        long[][] dp = new long[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            int wi = sc.nextInt();
            int vi = sc.nextInt();

            for (int j = 0; j <= w; j++) {
                if (j < wi) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wi] + vi);
                }
            }
        }

        System.out.println(dp[n][w]);
    }
//}

    @Test
    public void Case1() {

        String input = """
                4 7
                3 13
                3 17
                5 29
                1 10
                
                """;

        String expected = """
                40
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A19.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                4 100
                25 47
                25 53
                25 62
                25 88
                
                """;

        String expected = """
                250
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A19.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                10 285
                29 8000
                43 11000
                47 10000
                51 13000
                52 16000
                66 14000
                72 25000
                79 18000
                82 23000
                86 27000
                
                """;

        String expected = """
                87000
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A19.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A19.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
