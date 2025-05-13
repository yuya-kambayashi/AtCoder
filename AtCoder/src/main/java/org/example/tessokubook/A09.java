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

        // 入力
        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int[] A = new int[N + 1];
        int[] B = new int[N + 1];
        int[] C = new int[N + 1];
        int[] D = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
            C[i] = sc.nextInt();
            D[i] = sc.nextInt();
        }

        // 各日について加算
        int[][] X = new int[H + 2][W + 2];
        int[][] Z = new int[H + 2][W + 2];
        for (int t = 1; t <= N; t++) {
            X[A[t]][B[t]] += 1;
            X[A[t]][D[t] + 1] -= 1;
            X[C[t] + 1][B[t]] -= 1;
            X[C[t] + 1][D[t] + 1] += 1;
        }

        // 二次元累積和を求める
        for (int i = 0; i <= H; i++) {
            for (int j = 0; j <= W; j++) Z[i][j] = 0;
        }
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) Z[i][j] = Z[i][j - 1] + X[i][j];
        }
        for (int j = 1; j <= W; j++) {
            for (int i = 1; i <= H; i++) Z[i][j] = Z[i - 1][j] + Z[i][j];
        }

        // 出力
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (j >= 2) System.out.print(" ");
                System.out.print(Z[i][j]);
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
