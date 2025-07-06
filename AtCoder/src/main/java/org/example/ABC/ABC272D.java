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
public class ABC272D {

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

    // https://atcoder.jp/contests/abc272/submissions/60708559

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i * i <= m; i++) {
            int j = (int) Math.sqrt(m - i * i);
            if (i * i + j * j == m) {
                list.add(new int[]{i, j});
                if (i > 0) {
                    list.add(new int[]{-i, j});
                }
                if (j > 0) {
                    list.add(new int[]{i, -j});
                }
                if (i > 0 && j > 0) {
                    list.add(new int[]{-i, -j});
                }
            }
        }
        int[][] ans = new int[n][n];
        for (int[] t : ans) {
            Arrays.fill(t, -1);
        }
        ans[0][0] = 0;
        ArrayDeque<int[]> deq = new ArrayDeque<>();
        deq.add(new int[]{0, 0});
        while (deq.size() > 0) {
            int[] now = deq.pollFirst();
            for (int[] dd : list) {
                int nx = now[0] + dd[0];
                int ny = now[1] + dd[1];
                if (0 <= nx & nx < n && 0 <= ny && ny < n && ans[nx][ny] < 0) {
                    ans[nx][ny] = ans[now[0]][now[1]] + 1;
                    deq.addLast(new int[]{nx, ny});
                }
            }
        }
        for (int[] aa : ans) {
            System.out.print(aa[0]);
            for (int i = 1; i < n; i++) {
                System.out.print(" " + aa[i]);
            }
            System.out.println();
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                   3 1
                """;

        String expected = """
                                          0 1 2
                1 2 3
                2 3 4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC272D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                   10 5
                """;

        String expected = """
                                          0 3 2 3 2 3 4 5 4 5
                3 4 1 2 3 4 3 4 5 6
                2 1 4 3 2 3 4 5 4 5
                3 2 3 2 3 4 3 4 5 6
                2 3 2 3 4 3 4 5 4 5
                3 4 3 4 3 4 5 4 5 6
                4 3 4 3 4 5 4 5 6 5
                5 4 5 4 5 4 5 6 5 6
                4 5 4 5 4 5 6 5 6 7
                5 6 5 6 5 6 5 6 7 6
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC272D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC272D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC272D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
