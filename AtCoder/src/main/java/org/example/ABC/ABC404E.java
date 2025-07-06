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
public class ABC404E {

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
//import java.util.stream.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] cc = new int[n];
        int[] aa = new int[n];

        for (int i = 1; i < n; i++) {
            cc[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            aa[i] = sc.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();

        for (int p = 0; p < n; p++) {
            if (aa[p] > 0) {
                set.add(p);
                // iからゴールまでの経路
                List<List<Integer>> reverseGraph = new ArrayList<>();
                for (int i = 0; i < n; i++) reverseGraph.add(new ArrayList<>());

                for (int i = 1; i < n; i++) {
                    for (int j = i - cc[i]; j <= i - 1; j++) {
                        if (j >= 0) {
                            reverseGraph.get(j).add(i); // i→j の逆辺: j→i
                        }
                    }
                }

                int[] dist = new int[n];
                Arrays.fill(dist, -1); // -1 = 未訪問

                Queue<Integer> queue = new ArrayDeque<>();
                dist[0] = 0;
                queue.add(0);

                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int next : reverseGraph.get(cur)) {
                        if (dist[next] == -1) {
                            dist[next] = dist[cur] + 1;
                            set.add(next);
                            queue.add(next);
                        }
                    }
                }
            }
        }
        if (set.contains(n)) {
            System.out.println(set.size() - 1);
        } else {
            System.out.println(set.size());
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                5
                1 1 2 1
                1 0 0 1
                
                """;

        String expected = """
                3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC404E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                6
                1 2 1 3 1
                1 1 0 1 1
                
                """;

        String expected = """
                4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC404E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                16
                1 1 1 2 5 1 1 3 4 1 4 3 1 1 2
                1 0 0 0 1 0 0 1 1 0 0 0 0 0 1
                
                """;

        String expected = """
                7
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC404E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC404E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
