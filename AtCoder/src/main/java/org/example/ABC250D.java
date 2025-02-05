package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC250D {

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

    // https://atcoder.jp/contests/abc250/submissions/31585154

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final long n = sc.nextLong();
        List<Integer> ll = new ArrayList<>();
        for (int i = 1; i < 100_00_00; i++) {
            if (isPrime(i)) {
                ll.add(i);
            }
        }
        long cnt = 0;
        for (int i = 0; i < ll.size(); i++) {
            long num = ll.get(i);
            for (int j = i + 1; j < ll.size(); j++) {
                long num2 = ll.get(j);
                if (n / num >= num2 * num2 * num2) {
                    cnt++;
                } else {
                    break;
                }
            }
        }
        System.out.println(cnt);
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
        for (long i = 5; i * i <= n; i += 6) {
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
                   250
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC250D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                   1
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC250D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                   123456789012345
                """;

        String expected = """
                226863
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC250D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC250D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
