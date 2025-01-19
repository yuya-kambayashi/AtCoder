package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC389D {

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

    // 円内に収まるかを判定
    private static boolean isContained(int i, int j, long R2) {
        double[] xOffsets = {0.5, 0.5, -0.5, -0.5};
        double[] yOffsets = {0.5, -0.5, 0.5, -0.5};

        for (int k = 0; k < 4; k++) {
            double x = i + xOffsets[k];
            double y = j + yOffsets[k];

            // 原点との距離がR以内であるかをチェック
            if (x * x + y * y > R2) {
                return false;
            }
        }

        return true;
    }

    // 有効な正方形の数を数える
    public static int countValidSquares(int R) {
        long R2 = (long) R * R;  // 半径Rの2乗
        int count = 0;

        // iの範囲を- Rから R まで
        for (int i = -R; i <= R; i++) {
            int low = -R;
            int high = R;
            int validJ = 0;

            // j の範囲を二分探索で絞り込む
            while (low <= high) {
                int mid = (low + high) / 2;

                if (isContained(i, mid, R2)) {
                    // mid が有効な場合、j の範囲を狭めてさらに探索
                    validJ = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            // j の範囲の正方形が有効ならカウント
            for (int j = -validJ; j <= validJ; j++) {
                if (isContained(i, j, R2)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(); // 半径Rの入力
        sc.close();

        // 有効な正方形の数を計算
        int result = countValidSquares(R);
        System.out.println(result);
    }
//}

    @Test
    public void Case1() {

        String input = """
                2
                """;

        String expected = """
                5
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC389D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                4
                """;

        String expected = """
                37
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC389D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                26
                """;

        String expected = """
                2025
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC389D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC389D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
