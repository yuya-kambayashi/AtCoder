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
public class ABC269D {

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

    // https://atcoder.jp/contests/abc269/submissions/34969401

    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[] xx = new int[n];
        int[] yy = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            xx[i] = sc.nextInt();
            yy[i] = sc.nextInt();
            set.add(xx[i] + "," + yy[i]);
        }

        for (int i = 0; i < n; i++) {
            if (set.contains(xx[i] + "," + yy[i])) {
                set.remove(xx[i] + "," + yy[i]);
                count++;
                dfs(xx[i], yy[i]);
            }
        }

        System.out.println(count);
    }

    static void dfs(int a, int b) {
        int[] xa = {0, 1, 1, 0, -1, -1};
        int[] ya = {1, 1, 0, -1, -1, 0};
        for (int i = 0; i < 6; i++) {
            if (set.contains((a + xa[i]) + "," + (b + ya[i]))) {
                set.remove((a + xa[i]) + "," + (b + ya[i]));
                dfs(a + xa[i], b + ya[i]);
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       6
                -1 -1
                0 1
                0 2
                1 0
                1 2
                2 0
                """;

        String expected = """
                3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC269D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       4
                5 0
                4 1
                -3 -4
                -2 -5
                """;

        String expected = """
                4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC269D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       5
                2 1
                2 -1
                1 0
                3 1
                1 -1
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC269D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC269D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
