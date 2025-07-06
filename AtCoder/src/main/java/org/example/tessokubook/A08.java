package org.example.tessokubook;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.template.StandardInputSnatcher;
import org.example.template.StandardOutputSnatcher;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Test;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class A08 {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int h = sc.nextInt();
        final int w = sc.nextInt();
        int[][] xxx = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                xxx[i][j] = sc.nextInt();
            }
        }

        long[][] xxx2 = new long[h][w + 1];
        for (int i = 0; i < h; i++) {
            xxx2[i][0] = 0;
            for (int j = 1; j <= w; j++) {
                xxx2[i][j] = xxx2[i][j - 1] + xxx[i][j - 1];
            }
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            long ans = 0;
            for (int row = a - 1; row < c; row++) {
                ans += xxx2[row][d] - xxx2[row][b - 1];
            }

            System.out.println(ans);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                5 5
                2 0 0 5 1
                1 0 3 0 0
                0 8 5 0 2
                4 1 0 0 6
                0 9 2 7 0
                2
                2 2 4 5
                1 1 5 5
                
                """;

        String expected = """
                25
                56
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A08.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                4 4
                1 1 1 1
                1 1 1 1
                1 1 1 1
                1 1 1 1
                2
                1 1 1 1
                2 2 2 2
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A08.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A08.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A08.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
