package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC387D {

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

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        char[][] ggg = new char[h][w];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Coord start = null;
        Coord end = null;

        for (int i = 0; i < h; i++) {
            String s = sc.next();
            ggg[i] = s.toCharArray();

            for (int j = 0; j < w; j++) {
                if (ggg[i][j] == 'S') {
                    start = new Coord(i, j, 0);
                }
                if (ggg[i][j] == 'G') {
                    end = new Coord(i, j, 0);
                }
            }
        }
        int[][] dist1 = new int[1000][1000];
        int[][] dist2 = new int[1000][1000];
        for (int[] row : dist1) {
            Arrays.fill(row, -1);
        }
        for (int[] row : dist2) {
            Arrays.fill(row, -1);
        }
        // 横スタート
        int ans1 = -1, ans2 = -1;
        {

            Queue<Coord> que = new LinkedList<>();
            dist1[start.row][start.col] = 0;
            que.add(start);

            while (!que.isEmpty()) {
                Coord coord = que.poll();
                int row = coord.row;
                int col = coord.col;
                int way = coord.way;


                if (row == end.row && col == end.col) {
                    ans1 = dist1[row][col];
                    break;
                }

                if (way == 0) {
                    for (int dir = 0; dir < 4; dir += 2) {
                        int nrow = row + dx[dir];
                        int ncol = col + dy[dir];

                        if (nrow < 0 || nrow >= h || ncol < 0 || ncol >= w) {
                            continue;
                        }

                        if (ggg[nrow][ncol] == '#') {
                            continue;
                        }

                        if (dist1[nrow][ncol] == -1) {


                            dist1[nrow][ncol] = dist1[row][col] + 1;
                            que.add(new Coord(nrow, ncol, 1));

                        }
                    }
                } else if (way == -1) {

                    for (int dir = 0; dir < 4; dir += 2) {
                        int nrow = row + dx[dir];
                        int ncol = col + dy[dir];

                        if (nrow < 0 || nrow >= h || ncol < 0 || ncol >= w) {
                            continue;
                        }

                        if (ggg[nrow][ncol] == '#') {
                            continue;
                        }

                        if (dist1[nrow][ncol] == -1) {
                            dist1[nrow][ncol] = dist1[row][col] + 1;
                            que.add(new Coord(nrow, ncol, 1));
                        }
                    }
                } else if (way == 1) {

                    for (int dir = 1; dir < 4; dir += 2) {
                        int nrow = row + dx[dir];
                        int ncol = col + dy[dir];

                        if (nrow < 0 || nrow >= h || ncol < 0 || ncol >= w) {
                            continue;
                        }

                        if (ggg[nrow][ncol] == '#') {
                            continue;
                        }

                        if (dist1[nrow][ncol] == -1) {
                            dist1[nrow][ncol] = dist1[row][col] + 1;
                            que.add(new Coord(nrow, ncol, -1));
                        }
                    }
                }
            }
        }
        {

            Queue<Coord> que = new LinkedList<>();
            dist2[start.row][start.col] = 0;
            que.add(start);

            while (!que.isEmpty()) {
                Coord coord = que.poll();
                int row = coord.row;
                int col = coord.col;
                int way = coord.way;


                if (row == end.row && col == end.col) {
                    ans2 = dist2[row][col];
                    break;
                }

                if (way == 0) {
                    for (int dir = 1; dir < 4; dir += 2) {
                        int nrow = row + dx[dir];
                        int ncol = col + dy[dir];

                        if (nrow < 0 || nrow >= h || ncol < 0 || ncol >= w) {
                            continue;
                        }

                        if (ggg[nrow][ncol] == '#') {
                            continue;
                        }

                        if (dist2[nrow][ncol] == -1) {


                            dist2[nrow][ncol] = dist2[row][col] + 1;
                            que.add(new Coord(nrow, ncol, -1));

                        }
                    }
                } else if (way == -1) {

                    for (int dir = 0; dir < 4; dir += 2) {
                        int nrow = row + dx[dir];
                        int ncol = col + dy[dir];

                        if (nrow < 0 || nrow >= h || ncol < 0 || ncol >= w) {
                            continue;
                        }

                        if (ggg[nrow][ncol] == '#') {
                            continue;
                        }

                        if (dist2[nrow][ncol] == -1) {
                            dist2[nrow][ncol] = dist2[row][col] + 1;
                            que.add(new Coord(nrow, ncol, 1));
                        }
                    }
                } else if (way == 1) {

                    for (int dir = 1; dir < 4; dir += 2) {
                        int nrow = row + dx[dir];
                        int ncol = col + dy[dir];

                        if (nrow < 0 || nrow >= h || ncol < 0 || ncol >= w) {
                            continue;
                        }

                        if (ggg[nrow][ncol] == '#') {
                            continue;
                        }

                        if (dist2[nrow][ncol] == -1) {
                            dist2[nrow][ncol] = dist2[row][col] + 1;
                            que.add(new Coord(nrow, ncol, -1));
                        }
                    }
                }
            }
        }

        if (ans1 == -1 && ans2 == -1) {
            System.out.println(-1);
        } else if (ans1 == -1) {
            System.out.println(ans2);
        } else if (ans2 == -1) {
            System.out.println(ans1);
        } else {
            System.out.println(Math.min(ans1, ans2));
        }

    }

    static class Coord {

        int row, col, way;

        Coord(int row, int col, int way) {
            this.row = row;
            this.col = col;
            this.way = way;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                3 5
                .S#.G
                .....
                .#...
                
                """;

        String expected = """
                7
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC387D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                3 5
                ..#.G
                .....
                S#...
                
                """;

        String expected = """
                -1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC387D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                8 63
                ...............................................................
                ..S...#............................#####..#####..#####..####G..
                ..#...#................................#..#...#......#..#......
                ..#####..####...####..####..#..#...#####..#...#..#####..#####..
                ..#...#..#..#...#..#..#..#..#..#...#......#...#..#..........#..
                ..#...#..#####..####..####..####...#####..#####..#####..#####..
                ................#.....#........#...............................
                ................#.....#........#...............................
                
                """;

        String expected = """
                148
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC387D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                1
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC387D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
