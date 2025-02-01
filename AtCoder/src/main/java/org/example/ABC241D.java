package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC241D {

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

    // https://atcoder.jp/contests/abc241/submissions/43048177

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int q = sc.nextInt();
        TreeMap<Long, Integer> map = new TreeMap<>();

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            long x = sc.nextLong();
            if (t == 1) {
                map.put(x, map.getOrDefault(x, 0) + 1);
                //map.merge(x, 1, Integer::sum);

            } else if (t == 2) {
                int k = sc.nextInt();

                Long ans = x + 1;
                while (k > 0 && ans != null) {
                    ans = map.floorKey(ans - 1);
                    if (ans != null) {
                        k -= map.get(ans);
                    }
                }
                if (ans != null) {
                    System.out.println(ans);
                } else {
                    System.out.println(-1);
                }

            } else if (t == 3) {
                int k = sc.nextInt();

                Long ans = x - 1;
                while (k > 0 && ans != null) {
                    ans = map.ceilingKey(ans + 1);
                    if (ans != null) {
                        k -= map.get(ans);
                    }
                }
                if (ans != null) {
                    System.out.println(ans);
                } else {
                    System.out.println(-1);
                }
            }
        }

        System.out.println();
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       11
                1 20
                1 10
                1 30
                1 20
                3 15 1
                3 15 2
                3 15 3
                3 15 4
                2 100 5
                1 1
                2 100 5
                """;

        String expected = """
                                          20
                20
                30
                -1
                -1
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC241D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC241D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                   IN3
                """;

        String expected = """
                OUT3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC241D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                   IN4
                """;

        String expected = """
                OUT4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC241D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
