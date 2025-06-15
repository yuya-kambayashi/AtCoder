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
public class ABC410D {

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

    //public class Main {
    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Edge>[] graph;
    static int[] xorTo;
    static boolean[] visited;
    static List<Integer> basis = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), w = sc.nextInt();
            graph[a].add(new Edge(b, w));
            graph[b].add(new Edge(a, w));
        }

        xorTo = new int[N + 1];
        visited = new boolean[N + 1];

        dfs(1, 0);

        if (!visited[N]) {
            System.out.println(-1);
            return;
        }

        int answer = xorTo[N];
        for (int b : basis) {
            answer = Math.min(answer, answer ^ b);
        }

        System.out.println(answer);
    }

    static void dfs(int node, int xorVal) {
        visited[node] = true;
        xorTo[node] = xorVal;

        for (Edge e : graph[node]) {
            if (!visited[e.to]) {
                dfs(e.to, xorVal ^ e.weight);
            } else {
                int cycle = xorVal ^ xorTo[e.to] ^ e.weight;
                if (cycle != 0) addToBasis(cycle);
            }
        }
    }

    static void addToBasis(int x) {
        for (int b : basis) {
            x = Math.min(x, x ^ b);
        }
        if (x != 0) basis.add(x);
    }
    //}

    @Test
    public void Case1() {

        String input = """
                3 3
                1 2 4
                2 3 5
                1 3 2
                
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC410D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                4 4
                1 4 7
                4 2 2
                2 3 4
                3 4 1
                
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC410D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                999 4
                1 2 9
                2 1 8
                1 2 7
                1 1 6
                
                """;

        String expected = """
                -1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC410D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC410D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
