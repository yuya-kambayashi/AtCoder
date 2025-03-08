package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC201D {

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

    // https://atcoder.jp/contests/abc201/submissions/44842311
    // #DP 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        int[][] ggg = new int[h][w];
        for (int i = 0; i < h; i++) {
            String s = sc.next();
            int j = 0;
            for (char c : s.toCharArray()) {
                if (c == '+') {
                    ggg[i][j] = 1;
                } else {
                    ggg[i][j] = -1;
                }
                j++;
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ((i + j) % 2 == 0) {
                    ggg[i][j] *= -1;
                }
            }
        }
        int[][] scores = new int[h][w];
        scores[h - 1][w - 1] = 0;
        for (int y = h - 2; y >= 0; y--) {
            scores[y][w - 1] = scores[y + 1][w - 1] + ggg[y + 1][w - 1];
        }
        for (int x = w - 2; x >= 0; x--) {
            scores[h - 1][x] = scores[h - 1][x + 1] + ggg[h - 1][x + 1];
        }
        for (int y = h - 2; y >= 0; y--) {
            for (int x = w - 2; x >= 0; x--) {
                int down = scores[y + 1][x] + ggg[y + 1][x];
                int right = scores[y][x + 1] + ggg[y][x + 1];
                if (isMaxmize(x, y)) {
                    scores[y][x] = Math.max(down, right);
                } else {
                    scores[y][x] = Math.min(down, right);
                }
            }
        }
        String ret = "Draw";
        if (scores[0][0] > 0) {
            ret = "Takahashi";
        } else if (scores[0][0] < 0) {
            ret = "Aoki";
        }
        System.out.println(ret);
    }

    static boolean isMaxmize(int x, int y) {
        return (x + y) % 2 == 0;
    }
//}


    @Test
    public void Case1() {

        String input = """
                                       3 3
                ---
                +-+
                +--
                """;

        String expected = """
                Takahashi
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC201D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       2 4
                +++-
                -+-+
                """;

        String expected = """
                Aoki
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC201D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       1 1
                -
                """;

        String expected = """
                Draw
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC201D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC201D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
