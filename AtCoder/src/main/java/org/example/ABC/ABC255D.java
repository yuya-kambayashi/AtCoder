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
public class ABC255D {

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

    // https://atcoder.jp/contests/abc255/submissions/32407102

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int q = sc.nextInt();
        long[] aa = new long[n + 1];
        long[] temp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            aa[i] = sc.nextLong();
        }
        Arrays.sort(aa);
        System.arraycopy(aa, 0, temp, 0, n + 1);
        for (int i = 1; i <= n; i++) {
            aa[i] += aa[i - 1];
        }
        for (int i = 0; i < q; i++) {
            long x = sc.nextLong();
            int left = 0, right = n;
            while (left < right) {
                int mid = (left + right) / 2;
                if (temp[mid] >= x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (temp[left] > x) {
                left--;
            }
            System.out.println(x * left - aa[left] + aa[n] - aa[left] - x * (n - left));
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       5 3
                6 11 2 5 5
                5
                20
                0
                """;

        String expected = """
                                          10
                71
                29
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC255D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       10 5
                1000000000 314159265 271828182 141421356 161803398 0 777777777 255255255 536870912 998244353
                555555555
                321654987
                1000000000
                789456123
                0
                """;

        String expected = """
                                          3316905982
                2811735560
                5542639502
                4275864946
                4457360498
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC255D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC255D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC255D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
