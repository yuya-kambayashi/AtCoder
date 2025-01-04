package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC208D {

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

    // https://atcoder.jp/contests/abc208/submissions/55611135
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        long[][] d = new long[n][n];
        final int INF = (int) 1e9;
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], INF);
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            a--;
            b--;
            d[a][b] = c;
        }
        for (int i = 0; i < n; i++) {
            d[i][i] = 0;
        }
        long ans = 0;
        for (int k = 0; k < n; k++) {
            long[][] next = new long[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    next[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    if (next[i][j] < INF) {
                        ans += next[i][j];
                    }
                }
            }
            d = next;
        }
        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       3 2
                1 2 3
                2 3 2
                """;

        String expected = """
                25
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC208D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                   3 0
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC208D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                                       5 20
                1 2 6
                1 3 10
                1 4 4
                1 5 1
                2 1 5
                2 3 9
                2 4 8
                2 5 6
                3 1 5
                3 2 1
                3 4 7
                3 5 9
                4 1 4
                4 2 6
                4 3 4
                4 5 8
                5 1 2
                5 2 5
                5 3 6
                5 4 5
                """;

        String expected = """
                517
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC208D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC208D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
