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
public class ABC211D {

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

    // https://atcoder.jp/contests/abc211/submissions/47100841
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mod = (int) 1e9 + 7;

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        List<List<Integer>> ggg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ggg.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;
            b--;
            ggg.get(a).add(b);
            ggg.get(b).add(a);
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(0);

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        long[] cnt = new long[n];
        dist[0] = 0;
        cnt[0] = 1;


        while (!que.isEmpty()) {
            int now = que.poll();

            var gg = ggg.get(now);

            for (var next : gg) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    cnt[next] = cnt[now];
                    que.add(next);
                } else if (dist[next] == dist[now] + 1) {
                    cnt[next] += cnt[now];
                    cnt[next] %= mod;
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
