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
public class ABC246D {

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

    // https://atcoder.jp/contests/abc246/submissions/30678560

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final long n = sc.nextLong();
        long ans = Long.MAX_VALUE;
        for (long a = 0; a * a * a <= n; a++) {
            int ng = -1;
            int ok = 1_000_001;
            while (ng + 1 < ok) {
                int mid = (ok + ng) / 2;
                long x = func(a, mid);
                if (n <= x) {
                    ok = mid;
                } else {
                    ng = mid;
                }
            }
            ans = Math.min(ans, func(a, ok));
        }
        System.out.println(ans);
    }

    static long func(long a, long b) {
        return a * a * a + a * a * b + a * b * b + b * b * b;
    }
//}

    @Test
    public void Case1() {

        String input = """
                   9
                """;

        String expected = """
                15
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC246D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                   0
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC246D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                   999999999989449206
                """;

        String expected = """
                1000000000000000000
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC246D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC246D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
