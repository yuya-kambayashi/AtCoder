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
public class ABC288D {

    final private StandardInputSnatcher in = new StandardInputSnatcher();
    final private StandardOutputSnatcher out = new StandardOutputSnatcher();

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

    // https://atcoder.jp/contests/abc288/editorial/5664
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int k = sc.nextInt();
        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }

        long[][] cum = new long[k][n + 1];
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < n; i++) {
                cum[j][i + 1] = cum[j][i] + (i % k == j ? aa[i] : 0);
            }
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int left = sc.nextInt() - 1;
            int right = sc.nextInt();

            long val = get(cum, 0, left, right);
            boolean same = true;
            for (int j = 1; j < k; j++) {
                if (val != get(cum, j, left, right)) {
                    same = false;
                    break;
                }
            }
            System.out.println(same ? "Yes" : "No");
        }
    }

    static long get(long[][] cum, int j, int l, int r) {
        return cum[j][r] - cum[j][l];
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       7 3
                3 -1 1 -2 2 0 5
                2
                1 6
                2 7
                """;

        String expected = """
                                          Yes
                No
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC288D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       20 4
                -19 -66 -99 16 18 33 32 28 26 11 12 0 -16 4 21 21 37 17 55 -19
                5
                13 16
                4 11
                3 12
                13 18
                4 10
                """;

        String expected = """
                                          No
                Yes
                No
                Yes
                No
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC288D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC288D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC288D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
