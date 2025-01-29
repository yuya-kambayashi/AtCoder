package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC235D {

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

    // https://atcoder.jp/contests/abc235/submissions/28542156

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int n = sc.nextInt();

        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        int[] dd = new int[10_000_000];
        Arrays.fill(dd, -1);
        dd[1] = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();
            long v = (long) cur * a;
            int next = cur * a;
            if (v < dd.length && dd[next] == -1) {
                que.add(next);
                dd[next] = dd[cur] + 1;
            }

            if (cur >= 10 && cur % 10 != 0) {
                String s = String.valueOf(cur);
                s = s.substring(s.length() - 1) + s.substring(0, s.length() - 1);
                next = Integer.parseInt(s);
                if (next < dd.length && dd[next] == -1) {
                    que.add(next);
                    dd[next] = dd[cur] + 1;
                }
            }
        }
        System.out.println(dd[n]);
    }
//}

    @Test
    public void Case1() {

        String input = """
                   3 72
                """;

        String expected = """
                4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC235D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                   2 5
                """;

        String expected = """
                -1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC235D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                   2 611
                """;

        String expected = """
                12
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC235D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                   2 767090
                """;

        String expected = """
                111
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC235D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
