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
public class ABC206D {

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

    // https://atcoder.jp/contests/abc206/submissions/55488299
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }

        UnionFind uf = new UnionFind(200010);
        for (int i = 0; i < n; i++) {
            uf.unite(aa[i], aa[n - 1 - i]);
        }

        int ans = 0;
        for (int i = 0; i < 200010; i++) {
            if (uf.root(i) == i) {
                ans += uf.size(i) - 1;
            }
        }
        System.out.println(ans);
    }

    static class UnionFind {
        private final int[] par;
        private final int[] siz;

        public UnionFind(int n) {
            par = new int[n];
            siz = new int[n];
            Arrays.fill(par, -1);
            Arrays.fill(siz, 1);
        }

        public int root(int x) {
            if (par[x] == -1) {
                return x;
            }
            return par[x] = root(par[x]);
        }

        public boolean same(int x, int y) {
            return root(x) == root(y);
        }

        public int size(int x) {
            return siz[root(x)];
        }

        public boolean unite(int x, int y) {
            x = root(x);
            y = root(y);

            if (x == y) {
                return false;
            }
            if (siz[x] > siz[y]) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            par[x] = y;
            siz[y] += siz[x];

            return true;
        }
    }

    //}
    @Test
    public void Case1() {

        String input = """
                                       8
                1 5 3 2 5 2 3 1
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC206D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test

    public void Case2() {

        String input = """
                                       7
                1 2 3 4 1 2 3
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC206D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       1
                200000
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC206D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC206D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
