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
public class A68 {

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

    // https://atcoder.jp/contests/tessoku-book/submissions/38027292
    static int n;
    static int m;
    static int[][] aaa;
    static Set<Integer> visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        aaa = new int[n][n];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            aaa[a][b] = c;
        }
        int ans = 0;
        while (true) {
            visited = new HashSet<>();
            visited.add(0);
            int t = dfs(0, n - 1, Integer.MAX_VALUE / 2);
            if (t == 0) {
                break;
            } else {
                ans += t;
            }
        }

        System.out.println(ans);
    }

    // 戻り値：実際に流した量
    // f: 流そうとしている量
    static int dfs(int start, int goal, int f) {
        if (start == goal) {
            return f;
        }

        for (int i = 0; i < n; i++) {
            // startからiに経路があって、まだ訪問してないなら
            if (aaa[start][i] > 0 && !visited.contains(i)) {
                visited.add(i);
                // 流量は、流そうとしている量と実際に流せる量の小さいほう
                int t = dfs(i, goal, Math.min(f, aaa[start][i]));
                if (t > 0) {
                    aaa[start][i] -= t;
                    aaa[i][start] += t;
                    return t;
                }
            }
        }
        return 0;
    }
//}

    @Test
    public void Case1() {

        String input = """
                6 7
                1 2 5
                1 4 4
                2 3 4
                2 5 7
                3 6 3
                4 5 3
                5 6 5
                
                """;

        String expected = """
                8
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A68.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A68.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A68.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A68.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
