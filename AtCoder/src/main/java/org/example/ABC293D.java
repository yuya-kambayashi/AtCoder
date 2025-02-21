package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC293D {

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

    // https://atcoder.jp/contests/abc293/submissions/39715193

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();

        List<List<Integer>> ggg = new ArrayList<>();
        int[] deg = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ggg.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            String b = sc.next();
            int c = sc.nextInt();
            String d = sc.next();

            ggg.get(a).add(c);
            ggg.get(c).add(a);

            deg[a]++;
            deg[c]++;
        }
        int x = 0, y = 0;
        boolean[] used = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            Queue<Integer> que = new LinkedList<>();
            used[i] = true;
            que.add(i);
            boolean f = true;

            while (!que.isEmpty()) {
                int now = que.poll();
                if (deg[now] != 2) {
                    f = false;
                }
                for (int g : ggg.get(now)) {
                    if (used[g]) {
                        continue;
                    }
                    que.add(g);
                    used[g] = true;
                }
            }
            if (f) {
                x++;
            } else {
                y++;
            }
        }
        System.out.println(x + " " + y);
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       5 3
                3 R 5 B
                5 R 3 B
                4 R 2 B
                """;

        String expected = """
                1 2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC293D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                   7 0
                """;

        String expected = """
                0 7
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC293D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       7 6
                5 R 3 R
                7 R 4 R
                4 B 1 R
                2 R 3 B
                2 B 5 B
                1 B 7 B
                """;

        String expected = """
                2 1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC293D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC293D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
