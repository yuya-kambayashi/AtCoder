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

    // https://atcoder.jp/contests/abc410/submissions/66783805

    static StringBuilder sb = new StringBuilder();
    static List<long[]>[] ggg;
    static Map<long[], Set<Long>> visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ggg = new ArrayList[n];
        visited = new HashMap<>();

        for (int i = 0; i < n; i++) {
            ggg[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            long w = sc.nextLong();
            long[] e = new long[]{b, w};
            ggg[a].add(e);
            visited.put(e, new HashSet<>());
        }
        long ans = solve(0, 0, Long.MAX_VALUE, n - 1);
        if (ans == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static long solve(int now, long xor, long min, int goal) {
        for (long[] e : ggg[now]) {
            int next = (int) e[0];
            long w = e[1];
            long next_xor = xor ^ w;

            if (!visited.get(e).contains(next_xor)) {
                visited.get(e).add(next_xor);
                min = Math.min(min, solve(next, next_xor, min, goal));
            }
        }
        if (now == goal) {
            return Math.min(min, xor);
        } else {
            return min;
        }
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
