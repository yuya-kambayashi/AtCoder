package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC405E {

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

    static final int MOD = 998244353;
    static final int MAX = 4000000; // A + B + C + D <= 4*10^6 なので余裕をもって確保
    static long[] fact = new long[MAX + 1];
    static long[] invFact = new long[MAX + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // リンゴ
        int B = sc.nextInt(); // オレンジ
        int C = sc.nextInt(); // バナナ
        int D = sc.nextInt(); // ブドウ

        initFactorials();

        // A + C + D 個の中で、A個を選んで左に配置（リンゴ < バナナ, リンゴ < ブドウ）
        long acd = comb(A + C + D, A);

        // B + D 個の中で、B個を選んで左に配置（オレンジ < ブドウ）
        long bd = comb(B + D, B);

        // 残りの果物を自由に並べる：多重順列全体
        long total = mul(acd, bd);
        System.out.println(total);
    }

    static void initFactorials() {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[MAX] = modInverse(fact[MAX]);
        for (int i = MAX - 1; i >= 1; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    static long comb(int n, int k) {
        if (n < k || k < 0) return 0;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    static long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    static long pow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }

    static long mul(long a, long b) {
        return a * b % MOD;
    }
//}

    @Test
    public void Case1() {

        String input = """
                1 1 1 1
                
                """;

        String expected = """
                5
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC405E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                1 2 4 8
                
                """;

        String expected = """
                2211
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC405E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                834150 21994 467364 994225
                
                """;

        String expected = """
                947921688
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC405E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC405E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
