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
public class ABC138D {

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
    static List<List<Integer>> tree;
    static int[] ins, outs, order;
    static long[] imos;
    static int idx = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        ins = new int[n + 1];
        outs = new int[n + 1];
        order = new int[n];
        dfs(1);

        imos = new long[n + 1];
        for (int i = 0; i < q; i++) {
            int p = sc.nextInt();
            long x = sc.nextLong();
            imos[ins[p]] += x;
            if (outs[p] < n) {
                imos[outs[p]] -= x;
            }
        }

        for (int i = 1; i < n; i++) {
            imos[i] += imos[i - 1];
        }

        long[] ret = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int node = order[i];
            ret[node] = imos[i];
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(ret[i] + " ");
        }
    }

    static void dfs(int root) {
        boolean[] visited = new boolean[tree.size()];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{root, -1});

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int node = cur[0];
            int parent = cur[1];

            if (visited[node]) {
                // 戻りがけ
                outs[node] = idx;
            } else {
                visited[node] = true;
                // 行きがけ
                ins[node] = idx;
                order[idx++] = node;
                stack.push(new int[]{node, parent});

                List<Integer> children = tree.get(node);
                for (int i = children.size() - 1; i >= 0; i--) {
                    int next = children.get(i);
                    if (next != parent) {
                        stack.push(new int[]{next, node});
                    }
                }
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                6 2
                1 2
                1 3
                2 4
                3 6
                2 5
                1 10
                1 10
                
                """;

        String expected = """
                20 20 20 20 20 20
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC138D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC138D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC138D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC138D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
