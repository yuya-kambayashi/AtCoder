package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC257D {

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

    // https://atcoder.jp/contests/abc257/submissions/32865689

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[] xx = new int[n];
        int[] yy = new int[n];
        int[] pp = new int[n];
        for (int i = 0; i < n; i++) {
            xx[i] = sc.nextInt();
            yy[i] = sc.nextInt();
            pp[i] = sc.nextInt();
        }
        long[][] dist = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = ((long) Math.abs(xx[i] - xx[j]) + (long) Math.abs(yy[i] - yy[j]) + pp[i] - 1) / pp[i];
            }

        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], Math.max(dist[i][k], dist[k][j]));
                }
            }
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long t = 0;
            for (int j = 0; j < n; j++) {
                t = Math.max(t, dist[i][j]);
            }
            ans = Math.min(ans, t);
        }

        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       4
                -10 0 1
                0 0 5
                10 0 1
                11 0 1
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC257D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       7
                20 31 1
                13 4 3
                -10 -15 2
                34 26 5
                -2 39 4
                0 -50 1
                5 -20 2
                """;

        String expected = """
                18
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC257D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC257D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC257D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
