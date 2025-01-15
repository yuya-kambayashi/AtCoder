package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC213D {

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

    // https://atcoder.jp/contests/abc213/submissions/58149700

    static int n;
    static List<ArrayList<Integer>> ggg;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        visited = new boolean[n];
        ggg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ggg.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;
            b--;
            ggg.get(a).add(b);
            ggg.get(b).add(a);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(ggg.get(i));
        }
        sb = new StringBuilder();
        visited[0] = true;
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int cur) {

        sb.append(cur + 1);
        sb.append(" ");

        for (var next : ggg.get(cur)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
                sb.append(cur + 1);
                sb.append(" ");
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       4
                1 2
                4 2
                3 1
                """;

        String expected = """
                1 2 4 2 1 3 1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC213D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       5
                1 2
                1 3
                1 4
                1 5
                """;

        String expected = """
                1 2 1 3 1 4 1 5 1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC213D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC213D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC213D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
