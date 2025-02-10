package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC258D {

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

    // https://atcoder.jp/contests/abc258/submissions/32944953

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        long x = sc.nextLong();

        long sum = 0;
        long ret = Long.MAX_VALUE;

        long[][] box = new long[n][2];

        for (int i = 0; i < n; i++) {
            box[i][0] = sc.nextLong();
            box[i][1] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            sum += box[i][0] + box[i][1];
            ret = Math.min(sum + box[i][1] * (x - 1), ret);
            x--;
            if (x == 0) {
                break;
            }
        }
        System.out.println(ret);
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       3 4
                3 4
                2 3
                4 2
                """;

        String expected = """
                18
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC258D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {
        String input = """
                                       10 1000000000
                3 3
                1 6
                4 7
                1 8
                5 7
                9 9
                2 4
                6 4
                5 1
                3 1
                """;

        String expected = """
                1000000076
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC258D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC258D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC258D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
