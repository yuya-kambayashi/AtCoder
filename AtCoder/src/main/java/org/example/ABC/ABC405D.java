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
//public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[] arrow = {'v', '>', '^', '<'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();

        char[][] grid = new char[h][w];
        char[][] ans = new char[h][w];
        int[][] dist = new int[h][w];
        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            String s = sc.next();
            for (int j = 0; j < w; j++) {
                grid[i][j] = s.charAt(j);
                ans[i][j] = grid[i][j];
                if (grid[i][j] == 'E') {
                    que.add(new int[]{i, j});
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = -1;
                }
            }
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                    continue;
                }
                if (grid[nx][ny] != '.') {
                    continue;
                }
                if (dist[nx][ny] != -1) {
                    continue;
                }
                dist[nx][ny] = dist[x][y] + 1;
                ans[nx][ny] = arrow[d];
                que.add(new int[]{nx, ny});
            }
        }
        for (var a : ans) {
            System.out.println(a);
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
