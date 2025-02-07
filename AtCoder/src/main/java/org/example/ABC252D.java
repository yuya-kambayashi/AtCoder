package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC252D {

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

    // https://atcoder.jp/contests/abc252/submissions/31907409

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        long total = (long) n * (n - 1) * (n - 2) / 6;

        for (int i : map.keySet()) {
            long num = (long) map.get(i);
            long dec = 0;
            if (num >= 3) {
                dec += num * (num - 1) * (num - 2) / 6;
            }
            if (num >= 2) {
                dec += (num * (num - 1) / 2) * (n - num);
            }
            total -= dec;
        }

        System.out.println(total);
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       4
                3 1 4 1
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC252D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       10
                99999 99998 99997 99996 99995 99994 99993 99992 99991 99990
                """;

        String expected = """
                120
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC252D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       15
                3 1 4 1 5 9 2 6 5 3 5 8 9 7 9
                """;

        String expected = """
                355
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC252D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC252D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
