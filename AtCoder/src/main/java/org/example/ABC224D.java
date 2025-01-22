package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC224D {

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

    // https://atcoder.jp/contests/abc224/editorial/2813

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int m = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        char[] ss = new char[9];
        Arrays.fill(ss, '9');
        for (int i = 1; i <= 8; i++) {
            int p = sc.nextInt();
            p--;
            ss[p] = (char) (i + '0');
        }
        String start = new String(ss);

        Queue<String> que = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();
        que.add(start);
        visited.put(start, 0);

        while (!que.isEmpty()) {
            String cur = que.poll();
            int nineIndex = cur.indexOf('9');

            for (int neighbor : graph.get(nineIndex + 1)) {
                char[] nextState = cur.toCharArray();

                char temp = nextState[neighbor - 1];
                nextState[neighbor - 1] = nextState[nineIndex];
                nextState[nineIndex] = temp;

                String next = new String(nextState);
                if (!visited.containsKey(next)) {
                    visited.put(next, visited.get(cur) + 1);
                    que.add(next);
                }
            }
        }
        String goal = "123456789";
        if (visited.containsKey(goal)) {
            System.out.println(visited.get(goal));
        } else {
            System.out.println(-1);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       5
                1 2
                1 3
                1 9
                2 9
                3 9
                3 9 2 4 5 6 7 8
                """;

        String expected = """
                5
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC224D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       5
                1 2
                1 3
                1 9
                2 9
                3 9
                1 2 3 4 5 6 7 8
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC224D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       12
                8 5
                9 6
                4 5
                4 1
                2 5
                8 9
                2 1
                3 6
                8 7
                6 5
                7 4
                2 3
                1 2 3 4 5 6 8 7
                """;

        String expected = """
                -1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC224D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                                       12
                6 5
                5 4
                4 1
                4 7
                8 5
                2 1
                2 5
                6 9
                3 6
                9 8
                8 7
                3 2
                2 3 4 6 1 9 7 8
                """;

        String expected = """
                16
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC224D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
