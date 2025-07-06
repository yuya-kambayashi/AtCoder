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
public class ABC404B {

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

    static char[][] ttt;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        char[][] sss = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            sss[i] = s.toCharArray();
        }
        ttt = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            ttt[i] = s.toCharArray();
        }

        // そのまま
        int diff1 = diff(sss);
        var s2 = rotate90Clockwise(sss);
        int diff2 = diff(s2) + 1;
        var s3 = rotate90Clockwise(s2);
        int diff3 = diff(s3) + 2;
        var s4 = rotate90Clockwise(s3);
        int diff4 = diff(s4) + 3;

        int ans = Math.min(diff1, Math.min(diff2, Math.min(diff3, diff4)));

        System.out.println(ans);
    }

    public static char[][] rotate90Clockwise(char[][] matrix) {

        char[][] rotated = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }

        return rotated;
    }


    static int diff(char[][] sss) {

        int diff = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (sss[row][col] != ttt[row][col]) {
                    diff++;
                }
            }
        }

        return diff;
    }
//}

    @Test
    public void Case1() {

        String input = """
                4
                ###.
                ..#.
                ..#.
                ..#.
                ...#
                ...#
                ###.
                ....
                
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC404B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                13
                .#..###..##..
                #.#.#..#.#.#.
                #.#.###..#...
                ###.#..#.#.#.
                #.#.###..##..
                .............
                ..#...#....#.
                .##..#.#..##.
                #.#..#.#.#.#.
                ####.#.#.####
                ..#..#.#...#.
                ..#...#....#.
                .............
                .............
                .#....#...#..
                .#...#.#..#..
                ####.#.#.####
                .#.#.###..#.#
                .##....#..##.
                .#....#...#..
                .............
                ..##..###.#.#
                .#.#.#..#.###
                .#.#..###.#.#
                .#.#.#..#.#.#
                ..##..###..#.
                
                """;

        String expected = """
                5
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC404B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC404B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC404B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
