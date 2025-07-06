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
public class ABC279D {

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

        final long a = sc.nextLong();
        final long b = sc.nextLong();

        //  java.util.function.Function<Long, Double> f = (n) -> (double) a / Math.sqrt(n + 1) + (double) b * n;

        long left = 0, right = a / b;
        while (right - left > 2) {
            long m1 = (2 * left + right) / 3;
            long m2 = (left + 2 * right) / 3;
            if (f(m1, a, b) > f(m2, a, b)) {
                left = m1;
            } else {
                right = m2;
            }
        }
        double ans = a;
        for (long i = left; i <= right; i++) {
            ans = Math.min(ans, f(i, a, b));
        }

        System.out.println(ans);
    }

    static double f(long n, long a, long b) {
        return (double) a / Math.sqrt(n + 1) + (double) b * n;
    }
//}

    @Test
    public void Case1() {

        String input = """
                   10 1
                """;

        String expected = """
                7.7735026919
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC279D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                   5 10
                """;

        String expected = """
                5.0000000000
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC279D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                   1000000000000000000 100
                """;

        String expected = """
                8772053214538.5976562500
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC279D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC279D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
