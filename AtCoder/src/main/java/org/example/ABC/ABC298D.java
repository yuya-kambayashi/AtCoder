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
public class ABC298D {

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

    // https://atcoder.jp/contests/abc298/submissions/55754929

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mod = 998244353;
        int q = sc.nextInt();
        Queue<Long> que = new LinkedList<>();
        que.add(1L);
        long now = 1;

        long[] mod10 = new long[q + 1];
        mod10[1] = 1;
        for (int i = 2; i <= q; i++) {
            mod10[i] = (mod10[i - 1] * 10) % mod;
        }

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                long x = sc.nextLong();
                now = (now * 10 + x) % mod;
                que.add(x);
            } else if (t == 2) {
                int len = que.size();
                long x = que.poll();
                now = (now - (mod10[len] * x) % mod);
                if (now < 0) {
                    now += mod;
                }

            } else if (t == 3) {
                System.out.println(now);
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       3
                3
                1 2
                3
                """;

        String expected = """
                                          1
                12
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC298D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       3
                1 5
                2
                3
                """;

        String expected = """
                5
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC298D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       11
                1 9
                1 9
                1 8
                1 2
                1 4
                1 4
                1 3
                1 5
                1 3
                2
                3
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC298D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                11
                1 1
                1 2
                1 3
                1 4
                1 5
                1 6
                1 7
                1 8
                1 9
                1 1
                3
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC298D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
