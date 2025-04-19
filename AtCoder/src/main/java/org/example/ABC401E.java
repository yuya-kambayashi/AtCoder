package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC401E {

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
    static List<List<Integer>> graph;
    static boolean[] active;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int m = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        UnionFind uf = new UnionFind(n);

        // グラフ構築 + UnionFindに追加
        for (int i = 0; i < m; i++) {
            final int u = sc.nextInt() - 1;
            final int v = sc.nextInt() - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
            uf.union(u, v);
        }

        int root1 = uf.find(0); // 頂点1の属する連結成分の代表

        active = new boolean[n];
        List<Integer> ans = new ArrayList<>();

        for (int k = 1; k <= n; k++) {
            active[k - 1] = true;

            // 違う連結成分なら -1
            if (uf.find(k - 1) != root1) {
                ans.add(-1);
                continue;
            }

            // 上位との接続がなければ前回の答えから1引いて使い回せる
            if (!ans.isEmpty() && ans.get(ans.size() - 1) != -1) {
                boolean hasUpper = false;
                for (var v : graph.get(k - 1)) {
                    if (v >= k) {
                        hasUpper = true;
                        break;
                    }
                }
                if (!hasUpper) {
                    ans.add(ans.get(ans.size() - 1) - 1);
                    continue;
                }
            }

            // BFSで連結確認
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            if (!active[0]) {
                ans.add(-1);
                continue;
            }

            queue.add(0);
            visited[0] = true;
            int count = 1;

            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (int v : graph.get(u)) {
                    if (!visited[v] && active[v]) {
                        visited[v] = true;
                        count++;
                        queue.add(v);
                    }
                }
            }

            if (count != k) {
                ans.add(-1);
            } else {
                HashSet<Integer> remove = new HashSet<>();
                for (int i = 0; i < k; i++) {
                    if (uf.find(i) == root1) {
                        for (int v : graph.get(i)) {
                            if (v >= k) {
                                remove.add(v);
                            }
                        }
                    }
                }
                ans.add(remove.size());
            }
        }

        for (var a : ans) {
            System.out.println(a);
        }
    }

    // Union-Find クラス
    static class UnionFind {
        int[] parent, size;

        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int rx = find(x), ry = find(y);
            if (rx == ry) return false;
            if (size[rx] < size[ry]) {
                int tmp = rx;
                rx = ry;
                ry = tmp;
            }
            parent[ry] = rx;
            size[rx] += size[ry];
            return true;
        }

        boolean same(int x, int y) {
            return find(x) == find(y);
        }

        int size(int x) {
            return size[find(x)];
        }
    }

//}

    @Test
    public void Case1() {

        String input = """
                6 7
                1 2
                1 5
                2 3
                2 4
                2 5
                3 6
                5 6
                
                """;

        String expected = """
                2
                3
                3
                2
                1
                0
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC401E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                5 4
                1 5
                2 3
                3 4
                4 5
                
                """;

        String expected = """
                1
                -1
                -1
                -1
                0
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC401E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                2 0
                
                """;

        String expected = """
                0
                -1
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC401E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                11 25
                6 9
                5 9
                2 3
                1 9
                10 11
                4 5
                9 10
                8 9
                7 8
                3 5
                1 7
                6 10
                4 7
                7 9
                1 10
                4 11
                3 8
                2 7
                3 4
                1 8
                2 8
                3 7
                2 10
                1 6
                6 11
                
                """;

        String expected = """
                5
                -1
                -1
                -1
                -1
                -1
                4
                3
                2
                1
                0
                
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC401E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
