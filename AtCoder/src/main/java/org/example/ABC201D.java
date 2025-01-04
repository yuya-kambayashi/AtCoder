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

    // https://atcoder.jp/contests/abc201/submissions/44842311
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int h = sc.nextInt();
        final int w = sc.nextInt();

        int[][] field = new int[h][w];
        for (int i = 0; i < h; i++) {
            String s = sc.next();
            int j = 0;
            for (char c : s.toCharArray()) {
                if (c == '+') {
                    field[i][j] = 1;
                } else {
                    field[i][j] = -1;
                }
                j++;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ((i + j) % 2 == 0) {
                    field[i][j] *= -1;
                }
            }
        }
        int[][] scores = new int[h][w];
        scores[h - 1][w - 1] = 0;
        for (int y = h - 2; y >= 0; y--) {
            int x = w - 1;
            scores[y][x] = scores[y + 1][x] + field[y + 1][x];
        }
        for (int x = w - 2; x >= 0; x--) {
            int y = h - 1;
            scores[y][x] = scores[y][x + 1] + field[y][x + 1];
        }
        for (int y = h - 2; y >= 0; y--) {
            for (int x = w - 2; x >= 0; x--) {
                int down = scores[y + 1][x] + field[y + 1][x];
                int right = scores[y][x + 1] + field[y][x + 1];
                if (isMaxmize(y, x)) {
                    scores[y][x] = Math.max(down, right);
                } else {
                    scores[y][x] = Math.min(down, right);
                }

            }
        }

        if (scores[0][0] == 0) {
            System.out.println("Draw");
        } else if (scores[0][0] > 0) {
            System.out.println("Takahashi");
        } else {
            System.out.println("Aoki");
        }
    }

    static boolean isMaxmize(int y, int x) {
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
