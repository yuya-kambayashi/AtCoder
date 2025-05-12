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
public class ABC209D {

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

    // https://atcoder.jp/contests/abc209/submissions/53813127
    static int n;
    static int q;
    static List<List<Integer>> ggg;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        q = sc.nextInt();
        ggg = new ArrayList<>();
        
        for (int i = 0; i < n + 1; i++) {
            List<Integer> tt = new ArrayList<>();
            ggg.add(tt);
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ggg.get(a).add(b);
            ggg.get(b).add(a);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        while (!deque.isEmpty()) {
            int now = deque.poll();
            List<Integer> ggNow = ggg.get(now);
            for (int g : ggNow) {
                if (dist[g] == -1) {
                    dist[g] = dist[now] + 1;
                    deque.add(g);
                }
            }
        }
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (dist[a] % 2 == dist[b] % 2) {
                System.out.println("Town");
            } else {
                System.out.println("Road");
            }
        }

    }
//}

    @Test
    public void Case1() {

        String input = """
                                       4 1
                1 2
                2 3
                2 4
                1 2
                """;

        String expected = """
                Road
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC209D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       5 2
                1 2
                2 3
                3 4
                4 5
                1 3
                1 5
                """;

        String expected = """
                                          Town
                Town
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC209D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       9 9
                2 3
                5 6
                4 8
                8 9
                4 5
                3 4
                1 9
                3 7
                7 9
                2 5
                2 6
                4 6
                2 4
                5 8
                7 8
                3 6
                5 6
                """;

        String expected = """
                                          Town
                Road
                Town
                Town
                Town
                Town
                Road
                Road
                Road
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC209D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC209D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
