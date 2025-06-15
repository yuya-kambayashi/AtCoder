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
public class ABC410E {

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

    static int N;
    static int[] A, B;
    static Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int H = sc.nextInt();
        int M = sc.nextInt();

        A = new int[N];
        B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }

        int result = dfs(0, H, M);
        System.out.println(result);
    }

    static int dfs(int i, int h, int m) {
        if (i == N) return 0;

        String key = i + "_" + h + "_" + m;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int res = 0;

        // 選ばない（ここで終わる）
        res = Math.max(res, 0);

        // 魔力で倒す
        if (m >= B[i]) {
            res = Math.max(res, 1 + dfs(i + 1, h, m - B[i]));
        }

        // 体力で倒す
        if (h >= A[i]) {
            res = Math.max(res, 1 + dfs(i + 1, h - A[i], m));
        }

        memo.put(key, res);
        return res;
    }
//}

    @Test
    public void Case1() {

        String input = """
                4 10 14
                5 8
                5 6
                7 9
                99 99
                
                """;

        String expected = """
                3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC410E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                3 3000 3000
                3 3
                3 3
                3 3
                
                """;

        String expected = """
                3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC410E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                10 8 8
                2 2
                2 3
                2 2
                1 2
                2 3
                1 2
                3 3
                3 2
                3 1
                3 2
                
                """;

        String expected = """
                9
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC410E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC410E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
