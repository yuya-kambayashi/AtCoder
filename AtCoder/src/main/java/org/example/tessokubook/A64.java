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
public class A64 {

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

    record Edge(int to, int cost) {
    }

    record E(int pos, int cost) {
    }


//import java.math.*;
//import java.util.*;
//public class Main {

    // https://atcoder.jp/contests/tessoku-book/submissions/56655364

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();

        var ggg = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            ggg[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            ggg[b].add(new Edge(a, c));
            ggg[a].add(new Edge(b, c));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<E> pq = new PriorityQueue<E>((e1, e2) -> e1.cost - e2.cost);
        pq.add(new E(1, 0));
        while (!pq.isEmpty()) {
            E cur = pq.poll();
            if (dist[cur.pos] <= cur.cost) {
                continue;
            }

            dist[cur.pos] = cur.cost;

            for (var edge : ggg[cur.pos]) {
                Edge e = (Edge) edge;

                int next = e.to;
                int nextCost = e.cost + cur.cost;

                if (dist[next] < nextCost) {
                    continue;
                }
                pq.add(new E(next, nextCost));
            }
        }
        for (int i = 1; i <= n; i++) {
            if (dist[i] < Integer.MAX_VALUE) {
                System.out.println(dist[i]);
            } else {
                System.out.println(-1);
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                6 7
                1 2 15
                1 4 20
                2 3 65
                2 5 4
                3 6 50
                4 5 30
                5 6 8
                
                """;

        String expected = """
                0
                15
                77
                20
                19
                27
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A64.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                15 30
                10 11 23
                11 13 24
                5 8 22
                10 15 18
                12 14 15
                2 10 11
                4 7 15
                5 7 15
                7 9 8
                8 12 1
                5 14 1
                10 14 17
                10 12 11
                8 10 6
                7 14 28
                6 9 1
                1 10 19
                4 5 4
                9 10 21
                7 10 21
                4 10 29
                5 10 8
                4 14 8
                11 12 24
                10 13 13
                3 10 1
                5 12 24
                2 15 23
                6 10 18
                6 15 25
                
                """;

        String expected = """
                0
                30
                20
                31
                27
                37
                40
                25
                38
                19
                42
                26
                32
                28
                37
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A64.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A64.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A64.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
