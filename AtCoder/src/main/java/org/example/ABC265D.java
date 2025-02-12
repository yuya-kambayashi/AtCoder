package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC265D {

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

    // https://atcoder.jp/contests/abc265/submissions/34848978

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final long p = sc.nextLong();
        final long q = sc.nextLong();
        final long r = sc.nextLong();
        Set<Long> set = new HashSet<>();
        long[] cur = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            long a = sc.nextLong();
            cur[i] = a + cur[i - 1];
            set.add(cur[i]);
        }

        for (int i = 0; i < n + 1; i++) {
            if (set.contains(p + cur[i]) && set.contains(p + q + cur[i]) && set.contains(p + q + r + cur[i])) {
                System.out.println("Yes");
                return;
            }
        }

        System.out.println("No");
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       10 5 7 5
                1 3 2 2 2 3 1 4 3 2
                """;

        String expected = """
                Yes
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC265D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       9 100 101 100
                31 41 59 26 53 58 97 93 23
                """;

        String expected = """
                No
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC265D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       7 1 1 1
                1 1 1 1 1 1 1
                """;

        String expected = """
                Yes
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC265D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC265D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
