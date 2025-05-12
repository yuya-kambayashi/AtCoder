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
public class ABC388C {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力を受け取る
        int n = sc.nextInt();
        int[] aa = new int[n];

        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }

        Arrays.sort(aa);

        long cnt = 0;


        // 各餅を基準にペアを数える
        for (int i = 0; i < n - 1; i++) {

            int target = aa[i] * 2;

            int left = 0;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (aa[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            cnt += n - left;

        }

        // ユニークなペアの数を出力
        System.out.println(cnt);
    }

//}

    @Test
    public void Case1() {

        String input = """
                6
                2 3 4 4 7 10
                
                """;

        String expected = """
                8
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC388C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                3
                387 388 389
                
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC388C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                32
                1 2 4 5 8 10 12 16 19 25 33 40 50 64 87 101 149 175 202 211 278 314 355 405 412 420 442 481 512 582 600 641
                
                """;

        String expected = """
                388
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC388C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC388C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
