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
public class ABC232D {

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

    // https://atcoder.jp/contests/abc232/submissions/53701950

    //    static int h;
//    static int w;
//    static char[][] grid;
//    static int ans;
//    static boolean visited[][];
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        h = sc.nextInt();
//        w = sc.nextInt();
//        grid = new char[h][w];
//        visited = new boolean[h][w];
//        for (int i = 0; i < h; i++) {
//            String s = sc.next();
//            grid[i] = s.toCharArray();
//        }
//        ans = 0;
//        dfs(0, 0, 0);
//
//        System.out.println(ans);
//    }
//
//    static void dfs(int row, int col, int count) {
//        count++;
//        visited[row][col] = true;
//        if (row + 1 < h && grid[row + 1][col] != '#' && !visited[row + 1][col]) {
//            dfs(row + 1, col, count);
//        }
//        if (col + 1 < w && grid[row][col + 1] != '#' && !visited[row][col + 1]) {
//            dfs(row, col + 1, count);
//        }
//        ans = Math.max(ans, count);
//
//    }
//}
//
// import java.math.*;
//import java.util.*;
//import java.util.stream.*;
//public class Main {
    // https://atcoder.jp/contests/abc232/submissions/47323146
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        char[][] grid = new char[h][w];
        for (int i = 0; i < h; i++) {
            grid[i] = sc.next().toCharArray();
        }

        int[][] fff = new int[h + 1][w + 1];
        for (int i = h - 1; i >= 0; i--) {
            for (int j = w - 1; j >= 0; j--) {
                if (grid[i][j] == '#') {
                    continue;
                }
                fff[i][j] = Math.max(fff[i + 1][j], fff[i][j + 1]) + 1;
            }
        }
        System.out.println(fff[0][0]);
    }
// }

    @Test
    public void Case2() {

        String input = """
                                       1 1
                .
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC232D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       5 5
                .....
                .....
                .....
                .....
                .....
                """;

        String expected = """
                9
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC232D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC232D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
