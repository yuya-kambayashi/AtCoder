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
public class A09 {

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

        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();

        int[] aa = new int[n + 1];
        int[] bb = new int[n + 1];
        int[] cc = new int[n + 1];
        int[] dd = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            aa[i] = sc.nextInt();
            bb[i] = sc.nextInt();
            cc[i] = sc.nextInt();
            dd[i] = sc.nextInt();
        }

        int[][] xxx = new int[h + 2][w + 2];
        int[][] zzz = new int[h + 2][w + 2];
        for (int i = 1; i <= n; i++) {
            xxx[aa[i]][bb[i]]++;
            xxx[aa[i]][dd[i] + 1]--;
            xxx[cc[i] + 1][bb[i]]--;
            xxx[cc[i] + 1][dd[i] + 1]++;
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                zzz[i][j] = zzz[i][j - 1] + xxx[i][j];
            }
        }
        for (int j = 1; j <= w; j++) {
            for (int i = 1; i <= h; i++) {
                zzz[i][j] += zzz[i - 1][j];
            }
        }
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                System.out.print(zzz[i][j] + " ");
            }
            System.out.println();
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                5 5 2
                1 1 3 3
                2 2 4 4
                
                """;

        String expected = """
                1 1 1 0 0
                1 2 2 1 0
                1 2 2 1 0
                0 1 1 1 0
                0 0 0 0 0
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A09.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A09.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A09.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A09.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
