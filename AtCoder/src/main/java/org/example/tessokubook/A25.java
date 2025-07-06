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
public class A25 {

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

    // https://atcoder.jp/contests/tessoku-book/submissions/38851228

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int h = sc.nextInt();
        final int w = sc.nextInt();
        char[][] grid = new char[h][w];
        for (int i = 0; i < h; i++) {
            String s = sc.next();
            grid[i] = s.toCharArray();
        }

        long[][] dp = new long[h][w];
        dp[0][0] = 1;
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {

                if (grid[row][col] == '#') {
                    continue;
                }

                if (row + 1 < h) {
                    if (grid[row + 1][col] == '.') {
                        dp[row + 1][col] += dp[row][col];
                    }
                }
                if (col + 1 < w) {
                    if (grid[row][col + 1] == '.') {
                        dp[row][col + 1] += dp[row][col];
                    }
                }
            }
        }

        System.out.println(dp[h - 1][w - 1]);

    }
//}

    @Test
    public void Case1() {

        String input = """
                4 8
                .....#..
                ........
                ..#...#.
                #.......
                
                """;

        String expected = """
                35
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A25.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                2 8
                ....#...
                ....#...
                
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A25.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                30 30
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                ..............................
                
                """;

        String expected = """
                30067266499541040
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A25.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A25.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
