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
public class ABC256D {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[] ll = new int[n];
        int[] rr = new int[n];
        for (int i = 0; i < n; i++) {
            ll[i] = sc.nextInt();
            rr[i] = sc.nextInt();
        }
        List<Pair> pp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pp.add(new Pair(ll[i], rr[i]));
        }
        Collections.sort(pp, Comparator.comparingInt(Pair::getLeft));

        List<Pair> ans = new ArrayList<>();
        ans.add(pp.get(0));
        for (int i = 1; i < n; i++) {
            Pair p = pp.get(i);

            if (p.left <= ans.get(ans.size() - 1).getRight()) {

                ans.get(ans.size() - 1).right = Math.max(ans.get(ans.size() - 1).right, p.right);
                ans.get(ans.size() - 1).left = Math.min(ans.get(ans.size() - 1).left, p.left);
            } else {
                ans.add(p);
            }
        }

        for (var p : ans) {
            System.out.println(p.left + " " + p.right);
        }
    }

    static class Pair {
        int left, right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       3
                10 20
                20 30
                40 50
                """;

        String expected = """
                                          10 30
                40 50
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC256D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       3
                10 40
                30 60
                20 50
                """;

        String expected = """
                10 60
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC256D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                3
                20 30
                10 50
                30 40
                """;

        String expected = """
                10 50
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC256D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC256D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
