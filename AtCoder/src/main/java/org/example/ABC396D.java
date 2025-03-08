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

//import java.util.*;

    // public class Main {
    static int N, M;
    static ArrayList<int[]>[] graph;
    static long[] xorDist;
    static ArrayList<Long> basis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();
            graph[u].add(new int[]{v, (int) w});
            graph[v].add(new int[]{u, (int) w});
        }

        // 1. 各頂点へのXOR距離を求める
        xorDist = new long[N + 1];
        Arrays.fill(xorDist, -1);
        xorDist[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        basis = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int[] edge : graph[node]) {
                int next = edge[0];
                long weight = edge[1];

                if (xorDist[next] == -1) {
                    xorDist[next] = xorDist[node] ^ weight;
                    queue.add(next);
                } else {
                    // 閉路ができる -> XORベースに追加
                    long cycleXor = xorDist[node] ^ xorDist[next] ^ weight;
                    addBasis(cycleXor);
                }
            }
        }

        // 2. xorDist[N] をXORベースを用いて最小化
        long result = xorDist[N];
        for (long base : basis) {
            result = Math.min(result, result ^ base);
        }

        System.out.println(result);
        sc.close();
    }

    // XORベースに追加
    static void addBasis(long x) {
        for (long b : basis) {
            x = Math.min(x, x ^ b);
        }
        if (x > 0) basis.add(x);
        Collections.sort(basis); // 小さい順に並べておく
    }
    //}
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
                4 4
                1 2 3
                2 4 5
                1 3 4
                3 4 7
                
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
