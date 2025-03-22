package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC398D {

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

        int N = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();
        String S = sc.next();

        int OFFSET = N; // 負の座標を扱うためのオフセット
        int SIZE = 2 * N + 1; // 十分な広さのグリッド

        boolean[][] smokes = new boolean[SIZE][SIZE];
        smokes[OFFSET][OFFSET] = true; // (0, 0) をオフセットした座標に

        Map<Character, int[]> direction = new HashMap<>();
        direction.put('N', new int[]{-1, 0});
        direction.put('W', new int[]{0, -1});
        direction.put('S', new int[]{1, 0});
        direction.put('E', new int[]{0, 1});

        StringBuilder result = new StringBuilder();

        int pr = OFFSET + R, pc = OFFSET + C;

        int rmin = N, rmax = N, cmin = N, cmax = N;

        for (int t = 0; t < N; t++) {
            int[] move = direction.get(S.charAt(t));

            // 新しい煙を更新
            boolean[][] newSmoke = new boolean[SIZE][SIZE];

            switch (S.charAt(t)) {
                case 'N':
                    for (int r = rmin - 1; r <= rmax + 1; r++) {
                        for (int c = cmin - 1; c <= cmax + 1; c++) {
                            newSmoke[r][c] = smokes[r + 1][c];
                        }
                    }
                    rmin--;
                    break;
                case 'W':
                    for (int r = rmin - 1; r <= rmax + 1; r++) {
                        for (int c = cmin - 1; c <= cmax + 1; c++) {
                            newSmoke[r][c] = smokes[r][c + 1];
                        }
                    }
                    cmin--;
                    break;

                case 'S':
                    for (int r = rmin - 1; r <= rmax + 1; r++) {
                        for (int c = cmin - 1; c <= cmax + 1; c++) {
                            newSmoke[r][c] = smokes[r - 1][c];
                        }
                    }
                    rmax++;
                    break;
                case 'E':
                    for (int r = rmin - 1; r <= rmax + 1; r++) {
                        for (int c = cmin - 1; c <= cmax + 1; c++) {
                            newSmoke[r][c] = smokes[r][c - 1];
                        }
                    }
                    cmax++;
                    break;
            }

            // (0, 0) の位置を保持
            newSmoke[OFFSET][OFFSET] = true;
            smokes = newSmoke;

            result.append(smokes[pr][pc] ? '1' : '0');
        }

        System.out.println(result.toString());
    }
//}

    @Test
    public void Case1() {

        String input = """
                6 -2 1
                NNEEWS
                
                """;

        String expected = """
                001010
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC398D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                10 1 2
                NEESESWEES
                
                """;

        String expected = """
                0001101011
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC398D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                20 -1 -2
                WWNNWSWEWNSWWENSNWWN
                
                """;

        String expected = """
                00100111111000101111
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC398D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                6 -2 1
                NNEEWS
                """;

        String expected = """
                001010
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC398D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
