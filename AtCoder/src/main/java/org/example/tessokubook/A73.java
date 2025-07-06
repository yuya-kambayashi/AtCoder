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
public class A73 {

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

    // https://atcoder.jp/contests/tessoku-book/submissions/56679363

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();

        List<ArrayList<int[]>> ggg = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            ggg.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            ggg.get(a).add(new int[]{c, d, b});
            ggg.get(b).add(new int[]{c, d, a});
        }
        var pq = new PriorityQueue<int[]>((a1, a2) -> a1[0] == a2[0] ? -a1[1] + a2[1] : a1[0] - a2[0]);
        pq.add(new int[]{0, 0, 1});
        var visited = new boolean[n + 1];
        var currentCost = new int[n + 1];
        Arrays.fill(currentCost, Integer.MAX_VALUE);
        currentCost[1] = 0;

        while (true) {
            int[] now = pq.poll();

            if (visited[now[2]]) {
                continue;
            }
            visited[now[2]] = true;
            if (now[2] == n) {
                System.out.println(now[0] + " " + now[1]);
                return;
            }
            for (var gg : ggg.get(now[2])) {
                int cost = now[0] + gg[0];
                int tree = now[1] + gg[1];
                int to = gg[2];
                if (currentCost[to] < cost) {
                    continue;
                }
                currentCost[to] = cost;
                pq.add(new int[]{cost, tree, to});
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                3 3
                1 2 70 1
                2 3 20 1
                1 3 90 0
                
                """;

        String expected = """
                90 2
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A73.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A73.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A73.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A73.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
