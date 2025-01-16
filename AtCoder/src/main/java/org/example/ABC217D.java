package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC217D {

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

    // https://atcoder.jp/contests/abc217/submissions/60708217

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int l = sc.nextInt();
        final int q = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(l);
        for (int i = 0; i < q; i++) {
            int c = sc.nextInt();
            int x = sc.nextInt();
            if (c == 1) {
                set.add(x);
            } else {
                int bottom = set.floor(x);
                int top = set.ceiling(x);
                System.out.println(top - bottom);
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       5 3
                2 2
                1 3
                2 2
                """;

        String expected = """
                                          5
                3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC217D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       5 3
                1 2
                1 4
                2 3
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC217D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       100 10
                1 31
                2 41
                1 59
                2 26
                1 53
                2 58
                1 97
                2 93
                1 23
                2 84
                """;

        String expected = """
                                          69
                31
                6
                38
                38
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC217D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC217D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
