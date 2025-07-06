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
public class ABC282D {

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

    // https://atcoder.jp/contests/abc282/submissions/56163094

    static int n;
    static int m;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] color;
    static int[] cnum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            u--;
            v--;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        color = new int[n];
        Arrays.fill(color, -1);

        long ans = c2(n) - m;
        for (int i = 0; i < n; i++) {
            if (color[i] != -1) {
                continue;
            }
            cnum = new int[2];
            if (!dfs(i, 0)) {
                System.out.println(0);
                System.exit(0);
            }
            for (int s : cnum) {
                ans -= c2(s);
            }
        }

        System.out.println(ans);
    }

    static long c2(long n) {
        return n * (n - 1) / 2;
    }

    static boolean dfs(int v, int nc) {
        if (color[v] != -1) {
            return color[v] == nc;
        }
        color[v] = nc;
        cnum[nc]++;
        for (int u : graph.get(v)) {
            if (!dfs(u, 1 - nc)) {
                return false;
            }
        }
        return true;
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       5 4
                4 2
                3 1
                5 2
                3 2
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC282D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       4 3
                3 1
                3 2
                1 2
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC282D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       9 11
                4 9
                9 1
                8 2
                8 3
                9 2
                8 4
                6 7
                4 6
                7 5
                4 5
                7 8
                """;

        String expected = """
                9
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC282D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC282D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
