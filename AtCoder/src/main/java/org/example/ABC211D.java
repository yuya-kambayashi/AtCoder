package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC211D {

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

    // https://atcoder.jp/contests/abc211/submissions/47100841
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        List<List<Integer>> gg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            gg.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;
            b--;
            gg.get(a).add(b);
            gg.get(b).add(a);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        long[] cnt = new long[n];

        final long mod = 1000000007;

        Queue<Integer> que = new ArrayDeque<Integer>();
        que.add(0);
        dist[0] = 0;
        cnt[0] = 1;

        while (!que.isEmpty()) {
            int from = que.poll();
            for (int to : gg.get(from)) {

                if (dist[to] == -1) {
                    dist[to] = dist[from] + 1;
                    cnt[to] = cnt[from];
                    que.add(to);
                } else if (dist[to] == dist[from] + 1) {
                    cnt[to] += cnt[from];
                    cnt[to] %= mod;
                }
            }
        }
        System.out.println(cnt[n - 1]);
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       4 5
                2 4
                1 2
                2 3
                1 3
                3 4
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC211D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test

    public void Case2() {

        String input = """
                                       4 3
                1 3
                2 3
                2 4
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC211D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                   2 0
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC211D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                                       7 8
                1 3
                1 4
                2 3
                2 4
                2 5
                2 6
                5 7
                6 7
                """;

        String expected = """
                4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC211D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
