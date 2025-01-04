package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC214D {

    private StandardInputSnatcher in = new StandardInputSnatcher();
    private StandardOutputSnatcher out = new StandardOutputSnatcher();

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

    // https://atcoder.jp/contests/abc214/submissions/49650808
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        long ans = 0;

        UnionFind uf = new UnionFind(n);
        Line[] l = new Line[n - 1];
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            l[i] = new Line(a, b, c);
        }
        Arrays.sort(l);

        for (int i = 0; i < n - 1; i++) {
            long add = uf.unite(l[i].a, l[i].b);
            ans += add * (long) l[i].val;
        }
        System.out.print(ans);
    }

    static class UnionFind {

        private int[] root;
        private int[] size;

        public UnionFind(int n) {
            this.root = new int[n + 1];
            this.size = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }

        public long unite(int x, int y) {
            x = getRoot(x);
            y = getRoot(y);
            long retNum = (long) size[x] * (long) size[y];
            this.size[x] += this.size[y];
            this.size[y] = 0;
            this.root[y] = this.root[x];
            return retNum;
        }

        public int getRoot(int x) {
            if (x == this.root[x]) {
                return x;
            } else {
                return this.root[x] = getRoot(this.root[x]);
            }
        }

        public void rootPlus(int x, int y) {
            this.root[x] = y;
            this.size[y]++;
        }

        public boolean same(int x, int y) {
            x = getRoot(x);
            y = getRoot(y);
            return x == y;
        }
    }

    public static class Line implements Comparable<Line> {

        int a, b, val;

        public Line(int u, int v, int w) {
            this.a = u;
            this.b = v;
            this.val = w;
        }

        @Override
        public int compareTo(Line other) {
            return Integer.compare(this.val, other.val);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       3
                1 2 10
                2 3 20
                """;

        String expected = """
                50
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC214D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       5
                1 2 1
                2 3 2
                4 2 5
                3 5 14
                """;

        String expected = """
                76
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC214D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC214D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC214D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
