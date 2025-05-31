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
public class ABC408E {

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
//public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 頂点数
        int M = sc.nextInt();  // 辺数

        int[][] edges = new int[M][3];  // 辺リスト
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            edges[i] = new int[]{u, v, w};
        }

        for (int x = 1; x <= 30; x++) {
            if (hasValidPath(N, edges, x)) {
                System.out.println(x);
                return;
            }
        }
    }

    static boolean hasValidPath(int N, int[][] edges, int maxWeight) {
        // 重みが maxWeight 以下の辺だけを使ってグラフを構築
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (w <= maxWeight) {
                graph[u].add(v);
                graph[v].add(u);
            }
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int size = dfs(i);
                if (size >= 3) return true;
            }
        }
        return false;
    }

    static int dfs(int v) {
        visited[v] = true;
        int count = 1;
        for (int next : graph[v]) {
            if (!visited[next]) {
                count += dfs(next);
            }
        }
        return count;
    }
//}

    @Test
    public void Case1() {

        String input = """
                4 5
                1 2 1
                1 3 4
                2 3 2
                2 4 4
                3 4 3
                
                """;

        String expected = """
                3
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC408E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                3 5
                1 2 1
                1 2 2
                1 2 3
                1 2 4
                2 3 4
                
                """;

        String expected = """
                4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC408E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                8 12
                4 5 16691344
                5 7 129642441
                2 7 789275447
                3 8 335307651
                3 5 530163333
                5 6 811293773
                3 8 333712701
                1 2 2909941
                2 3 160265478
                5 7 465414272
                1 3 903373004
                6 7 408299562
                
                """;

        String expected = """
                468549631
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC408E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC408E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
