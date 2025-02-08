package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC253D {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();

        long total = n * (n + 1) / 2;

        long sumA = 0;
        long sumB = 0;
        long sumAB = 0;
        for (int i = 1; a * i <= n; i++) {
            sumA += a * i;
        }
        for (int i = 1; b * i <= n; i++) {
            sumB += b * i;
        }
        long lcm = lcm(a, b);
        for (int i = 1; lcm * i <= n; i++) {
            sumAB += lcm * i;
        }


        System.out.println(total - sumA - sumB + sumAB);
    }

    public static long gcd(long a, long b) {
        // bが0になるまで繰り返す
        while (b != 0) {
            long temp = b;
            b = a % b; // aをbで割った余りをbに代入
            a = temp; // bの値をaに代入
        }
        return a; // aが最大公約数
    }

    // 最小公倍数（LCM）を求める関数
    private static long lcm(long x, long y) {
        return x / gcd(x, y) * y;  // オーバーフロー回避
    }
//}

    @Test
    public void Case1() {

        String input = """
                   10 3 5
                """;

        String expected = """
                22
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC253D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                   1000000000 314 159
                """;

        String expected = """
                495273003954006262
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC253D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                   15 4 6
                """;

        String expected = """
                90
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC253D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC253D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
