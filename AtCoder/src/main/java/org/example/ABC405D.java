package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC405D {

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

        final int h = sc.nextInt();
        final int w = sc.nextInt();

        char[][] grid = new char[h][w];
        char[][] ans = new char[h][w];
        for (int i = 0; i < h; i++) {
            String s = sc.next();
            grid[i] = s.toCharArray();
            ans[i] = s.toCharArray();
        }

        List<Coord> ends = new ArrayList<>();

        Set<String> endset = new HashSet<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 'E') {
                    ends.add(new Coord(i, j, null));
                    endset.add(String.valueOf(i) + "," + String.valueOf(j));
                }
            }
        }
        // 非常口なし
        if (ends.isEmpty()) {
            for (var g : ans) {
                System.out.println(g);
            }
            return;
        }


        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                if (grid[i][j] == '#') {
                    continue;
                }
                if (ans[i][j] != '.') {
                    continue;
                }

                boolean[][] visited = new boolean[h][w];

                Coord start = new Coord(i, j, new ArrayList<Record>());

                Queue<Coord> que = new LinkedList<>();
                que.add(start);
                while (!que.isEmpty()) {
                    Coord cur = que.poll();
                    int row = cur.row;
                    int col = cur.col;
                    List<Record> records = cur.records;
                    visited[row][col] = true;

                    if (endset.contains(String.valueOf(row) + "," + String.valueOf(col))) {
                        // レコードを書き込む

                        for (var record : records) {
                            ans[record.row][record.col] = record.way.toCharArray()[0];
                        }
                    }

                    for (int dir = 0; dir < 4; dir++) {
                        int nextrow = row + dx[dir];
                        int nextcol = col + dy[dir];

                        if (nextrow < 0 || nextrow >= h || nextcol < 0 || nextcol >= w) {
                            continue;
                        }

                        if (grid[nextrow][nextcol] == '#') {
                            continue;
                        }

                        if (visited[nextrow][nextcol]) {
                            continue;
                        }

                        String d = "v";
                        if (dir == 1) {
                            d = ">";
                        } else if (dir == 2) {
                            d = "^";
                        } else if (dir == 3) {
                            d = "<";
                        }

                        List<Record> newList = new ArrayList<Record>(records);
                        Record newRecord = new Record(row, col, d);
                        newList.add(newRecord);


                        que.add(new Coord(nextrow, nextcol, newList));

                    }

                }
            }
        }
        for (var g : ans) {
            System.out.println(g);
        }
    }

    static class Coord {

        int row, col;
        List<Record> records;

        Coord(int row, int col, List<Record> records) {
            this.row = row;
            this.col = col;
            this.records = records;
        }
    }

    static class Record {
        int row, col;
        String way;

        Record(int row, int col, String way) {
            this.row = row;
            this.col = col;
            this.way = way;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                3 4
                ...E
                .#..
                ....
                
                """;

        String expected = """
                >>>E
                ^#>^
                >>>^
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC405D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                3 2
                ##
                ##
                ##
                
                """;

        String expected = """
                ##
                ##
                ##
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC405D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                7 20
                ....................
                ..#..#..####..#E##..
                ..#..#..#..#..#.....
                ..E###..#..#..####..
                .....#..#..E.....#..
                .....#..####..####..
                ....................
                
                """;

        String expected = """
                >v<<<<<>>>>>>>>v<<<<
                >v#^<#^^####v^#E##vv
                >v#^<#v^#>v#vv#^<<<<
                >>E###vv#>v#vv####^<
                >>^<<#vv#>>E<<<<<#^<
                >>^<<#vv####^<####^<
                >>^<<<<<>>>>^<<<<<^<
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC405D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC405D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
