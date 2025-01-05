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

        // すべてのiに対してcanPrimeだと青木のkachi勝ち
        // 一つでもcanPrimeできないと高橋の勝ち

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
        // 1以下の数は素数ではない
        if (n <= 1) {
            return false;
        }
        // 2と3は素数
        if (n <= 3) {
            return true;
        }
        // 2または3で割り切れる数は素数ではない
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        // 5以上の数を試し割り
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
//}

    @Test
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

    @Test
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
