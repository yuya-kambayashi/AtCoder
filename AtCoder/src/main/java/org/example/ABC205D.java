package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC205D {

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
    // https://atcoder.jp/contests/abc205/submissions/54710193

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int q = sc.nextInt();
        long[] as = new long[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextLong();
        }

        long[] sums = new long[n];
        sums[0] = as[0] - 1;
        for (int i = 0; i < n - 1; i++) {
            long a = as[i];
            long nextA = as[i + 1];
            sums[i + 1] = nextA - a - 1 + sums[i];
        }
        for (int i = 0; i < q; i++) {
            long k = sc.nextLong();

            if (k > sums[n - 1]) {
                System.out.println(as[n - 1] + k - sums[n - 1]);
                continue;
            } else if (k <= sums[0]) {
                System.out.println(k);
                continue;
            }

            int left = 0;
            int right = n - 1;
            while (right - left > 1) {
                int mid = (left + right) / 2;
                if (k <= sums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            long ans = as[left] + (k - sums[left]);
            System.out.println(ans);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       4 3
                3 5 6 7
                2
                5
                3
                """;

        String expected = """
                                          2
                9
                4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC205D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       5 2
                1 2 3 4 5 a
                1
                10
                """;

        String expected = """
                                          6
                15
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC205D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC205D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC205D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
