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
public class A66 {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int q = sc.nextInt();
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (t == 1) {
                uf.unite(u, v);

            } else if (t == 2) {
                int u1 = uf.find(u);
                int v1 = uf.find(v);
                String ret = "Yes";
                if (u1 != v1) {
                    ret = "No";
                }
                System.out.println(ret);

            }
        }
    }

    static class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void unite(int x, int y) {
            parent[find(x)] = find(y);
        }

        boolean same(int x, int y) {
            return find(x) == find(y);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                3 4
                1 1 2
                2 1 3
                1 2 3
                2 2 3
                
                """;

        String expected = """
                No
                Yes
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A66.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                12 12
                2 9 11
                1 1 7
                1 1 4
                2 3 6
                1 3 5
                2 3 5
                1 10 12
                1 4 8
                1 8 11
                2 10 12
                1 5 9
                2 6 8
                
                """;

        String expected = """
                No
                No
                Yes
                Yes
                No
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A66.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A66.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A66.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
