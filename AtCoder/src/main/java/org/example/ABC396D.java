package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC396D {

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
//import java.math.*;
//import java.util.*;
//import java.util.stream.*;
//public class Main {

    // https://atcoder.jp/contests/abc396/submissions/63541012
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[][] ggg = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ggg[i], -1L);
        }
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt() - 1;
            int u = sc.nextInt() - 1;
            long w = sc.nextLong();
            ggg[v][u] = w;
            ggg[u][v] = w;
        }
        long ans = bfs(ggg, new boolean[n], 0, 0);
        System.out.println(ans);
    }

    static public long bfs(long[][] ggg, boolean[] visited, long xor, int now) {
        if (now == ggg.length - 1) {
            return xor;
        }

        long min = Long.MAX_VALUE;
        for (int i = 0; i < ggg.length; i++) {
            if (!visited[i] && ggg[now][i] != -1) {
                boolean[] copy = Arrays.copyOf(visited, visited.length);
                copy[i] = true;
                long result;
                if (now == 0) {
                    result = bfs(ggg, copy, ggg[now][i], i);
                } else {
                    result = bfs(ggg, copy, xor ^ ggg[now][i], i);
                }
                min = Math.min(min, result);
            }
        }
        return min;
    }
//}

    @Test
    public void Case1() {

        String input = """
                4 4
                1 2 3
                2 4 5
                1 3 4
                3 4 7
                
                """;

        String expected = """
                3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC396D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                4 3
                1 2 1
                2 3 2
                3 4 4
                
                """;

        String expected = """
                7
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC396D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                7 10
                1 2 726259430069220777
                1 4 988687862609183408
                1 5 298079271598409137
                1 6 920499328385871537
                1 7 763940148194103497
                2 4 382710956291350101
                3 4 770341659133285654
                3 5 422036395078103425
                3 6 472678770470637382
                5 7 938201660808593198
                
                """;

        String expected = """
                186751192333709144
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC396D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC396D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
