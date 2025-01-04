package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC239D {

    private StandardInputSnatcher in = new StandardInputSnatcher();
    private StandardOutputSnatcher out = new StandardOutputSnatcher();

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

        final int a = sc.nextInt();
        final int b = sc.nextInt();
        final int c = sc.nextInt();
        final int d = sc.nextInt();

        List<Integer> ll = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            boolean canPrime = false;
            for (int j = c; j <= d; j++) {
                if (isPrime(i + j)) {
                    canPrime = true;
                    break;
                }
            }
            if (!canPrime) {
                System.out.println("Takahashi");
                return;
            }
        }
        System.out.println("Aoki");
    }

    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
//}

    // @Test
    public void Case1() {

        String input = """
                   2 3 3 4
                """;

        String expected = """
                Aoki
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC239D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                   1 100 50 60
                """;

        String expected = """
                Takahashi
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC239D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                   3 14 1 5
                """;

        String expected = """
                Aoki
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC239D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC239D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
