package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC263D {

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

    // https://atcoder.jp/contests/abc263/submissions/37235512

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final long left = sc.nextLong();
        final long right = sc.nextLong();
        long[] aa = new long[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }
        long[] ll = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ll[i + 1] = Math.min((i + 1) * left, ll[i] + aa[i]);
        }
        long[] rr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            rr[n - i - 1] = Math.min((i + 1) * right, rr[n - i] + aa[n - i - 1]);
        }
        long min = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            min = Math.min(min, ll[i] + rr[i]);
        }
        System.out.println(min);
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       5 4 3
                5 5 0 6 3
                """;

        String expected = """
                14
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC263D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       4 10 10
                1 2 3 4
                """;

        String expected = """
                10
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC263D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       10 -5 -3
                9 -6 10 -1 2 10 -1 7 -15 5
                """;

        String expected = """
                -58
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC263D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC263D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
