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
        int[][] xxx = new int[h + 2][w + 2];
        int[][] zzz = new int[h + 2][w + 2];
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                xxx[i][j] = sc.nextInt();
            }
        }
        int q = sc.nextInt();
        int[] aa = new int[q + 1];
        int[] bb = new int[q + 1];
        int[] cc = new int[q + 1];
        int[] dd = new int[q + 1];
        for (int i = 1; i <= q; i++) {
            aa[i] = sc.nextInt();
            bb[i] = sc.nextInt();
            cc[i] = sc.nextInt();
            dd[i] = sc.nextInt();
        }

        for (int i = 0; i <= h; i++) {
            for (int j = 0; j <= w; j++) {
                zzz[i][j] = 0;
            }
        }
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                zzz[i][j] = zzz[i][j - 1] + xxx[i][j];
            }
        }
        for (int j = 1; j <= w; j++) {
            for (int i = 1; i <= h; i++) {
                zzz[i][j] = zzz[i - 1][j] + zzz[i][j];
            }
        }
        for (int i = 1; i <= q; i++) {
            int a = aa[i];
            int b = bb[i];
            int c = cc[i];
            int d = dd[i];
            System.out.println(zzz[c][d] + zzz[a - 1][b - 1] - zzz[a - 1][d] - zzz[c][b - 1]);
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

    //@Test
    public void Case2() {

        String input = """
                
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
