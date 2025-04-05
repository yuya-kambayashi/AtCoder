package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC400D {

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

    static final int INF = Integer.MAX_VALUE;
    static final int[] di = {-1, 1, 0, 0};
    static final int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt(), W = sc.nextInt();
        sc.nextLine();

        char[][] grid = new char[H][W];
        for (int i = 0; i < H; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        int A = sc.nextInt() - 1, B = sc.nextInt() - 1;
        int C = sc.nextInt() - 1, D = sc.nextInt() - 1;

        int[][] dist = new int[H][W];
        for (int[] row : dist) Arrays.fill(row, INF);
        dist[A][B] = 0;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[]{A, B});

        boolean[][] visited = new boolean[H][W];

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int i = cur[0], j = cur[1];
            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;


            // 通常移動（コスト0）
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d], nj = j + dj[d];
                if (0 <= ni && ni < H && 0 <= nj && nj < W) {

                    if (grid[ni][nj] == '.') {
                        // if (dist[ni][nj] >= dist[i][j]) {
                        dist[ni][nj] = dist[i][j] + 1;
                        dq.addLast(new int[]{ni, nj});
                        //  }
                    } else if (grid[ni][nj] == '#') {
                        for (int k = 1; k <= 2; k++) {
                            int ti = i + di[d] * k;
                            int tj = j + dj[d] * k;
                            if (0 <= ti && ti < H && 0 <= tj && tj < W) {
                                if (grid[ti][tj] == '#') {
                                    grid[ti][tj] = '.';
                                    if (dist[ti][tj] == INF) {
                                        dist[ti][tj] = dist[i][j] + 1;
                                        //    dq.addLast(new int[]{ti, tj});
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(dist[C][D]);
    }

//}

    @Test
    public void Case1() {

        String input = """
                10 10
                ..........
                #########.
                #.......#.
                #..####.#.
                ##....#.#.
                #####.#.#.
                .##.#.#.#.
                ###.#.#.#.
                ###.#.#.#.
                #.....#...
                1 1 7 1
                
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC400D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                2 2
                .#
                #.
                1 1 2 2
                
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC400D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                1 3
                .#.
                1 1 1 3
                
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC400D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                20 20
                ####################
                ##...##....###...###
                #.....#.....#.....##
                #..#..#..#..#..#..##
                #..#..#....##..#####
                #.....#.....#..#####
                #.....#..#..#..#..##
                #..#..#.....#.....##
                #..#..#....###...###
                ####################
                ####################
                ##..#..##...###...##
                ##..#..#.....#.....#
                ##..#..#..#..#..#..#
                ##..#..#..#..#..#..#
                ##.....#..#..#..#..#
                ###....#..#..#..#..#
                #####..#.....#.....#
                #####..##...###...##
                ####################
                3 3 18 18
                
                """;

        String expected = """
                3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC400D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case5() {

        String input = """
                2 3
                .#.
                .#.
                1 1 1 3
                
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC400D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
