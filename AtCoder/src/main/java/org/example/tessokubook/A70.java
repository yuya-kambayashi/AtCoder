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
public class A70 {

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

    // https://atcoder.jp/contests/tessoku-book/submissions/66431997

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] visited = new boolean[1 << n];
        int start = 0;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a == 1) {
                start += (1 << i);
            }
        }
        List<Operation> opes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            opes.add(new Operation(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt() - 1));
        }

        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{start, 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (visited[cur[0]]) {
                continue;
            }
            visited[cur[0]] = true;

            if (cur[0] == (1 << n) - 1) {
                System.out.println(cur[1]);
                return;
            }

            for (int i = 0; i < m; i++) {
                int next = cur[0];
                next ^= (1 << opes.get(i).x);
                next ^= (1 << opes.get(i).y);
                next ^= (1 << opes.get(i).z);

                que.offer(new int[]{next, cur[1] + 1});
            }

        }


        System.out.println(-1);
    }

    static class Operation {
        int x, y, z;

        Operation(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                4 2
                0 1 1 0
                1 2 3
                2 3 4
                
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A70.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A70.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A70.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A70.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
