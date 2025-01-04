package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC203D {

    private StandardInputSnatcher in = new StandardInputSnatcher();
    private StandardOutputSnatcher out = new StandardOutputSnatcher();

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

    // https://atcoder.jp/contests/abc203/submissions/48991359
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int k = sc.nextInt();
        int[][] aaa = new int[n][n];
        List<Pair> pp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aaa[i][j] = sc.nextInt();
                pp.add(new Pair(i, j, aaa[i][j]));
            }
        }

        int target = (k * k / 2) + 1;

        Collections.sort(pp, Comparator.comparingInt(Pair::getVal));

        for (var p : pp) {

            boolean ok = true;
            int cntUpper = 0;
            for (int r = p.row; r < p.row + k; r++) {
                for (int c = p.col; c < p.col + k; c++) {
                    if (r < 0 || r >= n || c < 0 || c >= n) {
                        ok = false;
                        break;
                    }
                    if (aaa[r][c] > p.val) {
                        cntUpper++;
                    }
                }

            }
            if (cntUpper == target - 1) {
                System.out.println(p.val);
            }
        }

        System.out.println();
    }

    static class Pair {

        int row, col, val;

        public Pair(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        public int getVal() {
            return val;
        }

    }
//}

    @Test
    public void Case1() {

        String input = """
                                       3 2
                1 7 0
                5 8 11
                10 4 2
                """;

        String expected = """
                4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC203D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       3 3
                1 2 3
                4 5 6
                7 8 9
                """;

        String expected = """
                5
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC203D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC203D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC203D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
