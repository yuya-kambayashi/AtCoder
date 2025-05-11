package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC405B {

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

        final int n = sc.nextInt();
        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }

        long sum = 0;
        long squareSum = 0;
        for (int i = 0; i < n; i++) {
            int a = aa[i];
            sum += a;
            squareSum += a * a;
        }

        long ans = (sum * sum - squareSum) / 2;


        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        String input = """
                3
                4 2 3
                
                """;

        String expected = """
                26
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC405B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                2
                9 45
                
                """;

        String expected = """
                405
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC405B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                10
                7781 8803 8630 9065 8831 9182 8593 7660 7548 8617
                
                """;

        String expected = """
                3227530139
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC405B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC405B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}

