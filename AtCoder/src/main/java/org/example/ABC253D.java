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

        final long n = sc.nextLong();
        final long a = sc.nextLong();
        final long b = sc.nextLong();
        long gcd = gcd(a, b);
        long i = 1;
        long multiGCD = 0;
        while (true) {

            long t = i * gcd;
            if (t % a != 0 && t % b != 0) {
                i++;
                continue;
            }
            if (t > n) {
                break;
            }
            multiGCD += t;
            i++;
        }
        System.out.println(((n * (n + 1)) / 2) - multiGCD);

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
