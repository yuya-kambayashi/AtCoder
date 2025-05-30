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
public class ABC277D {

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

    // https://atcoder.jp/contests/abc277/submissions/36511746

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        int[] aa = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
            sum += aa[i];
        }
        Arrays.sort(aa);
        var sums = new ArrayList<Long>();
        for (int i = 0; i < n; ) {
            int now = aa[i];
            long s = 0;
            while (i < n && (aa[i] == now || aa[i] == now + 1)) {
                s += aa[i];
                now = aa[i];
                i++;
            }
            sums.add(s);
        }
        if (aa[0] == 0 && aa[aa.length - 1] == m - 1 && sums.size() > 1) {
            sums.set(0, sums.get(0) + sums.get(sums.size() - 1));
            sums.remove((sums.size() - 1));
        }

        System.out.println(sum - Collections.max(sums));
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       9 7
                3 0 2 5 5 3 0 6 3
                """;

        String expected = """
                11
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC277D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       1 10
                4
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC277D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       20 20
                18 16 15 9 8 8 17 1 3 17 11 9 12 11 7 3 2 14 3 12
                """;

        String expected = """
                99
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC277D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC277D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
