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
public class ABC212D {

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

    // https://atcoder.jp/contests/abc212/submissions/53800902
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int q = sc.nextInt();
        int[] pp = new int[q];
        long offset = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < q; i++) {
            pp[i] = sc.nextInt();
            if (pp[i] == 1) {
                long x = sc.nextLong();
                pq.add(x - offset);
            } else if (pp[i] == 2) {
                offset += sc.nextLong();
            } else if (pp[i] == 3) {
                System.out.println(pq.poll() + offset);
            }
        }

    }
//}

    @Test
    public void Case1() {

        String input = """
                   5
                   1 3
                   1 5
                   3
                   2 2
                   3
                """;

        String expected = """
                3
                7
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC212D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                   6
                   1 1000000000
                   2 1000000000
                   2 1000000000
                   2 1000000000
                   2 1000000000
                   3
                """;

        String expected = """
                5000000000
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC212D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC212D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                                       7 8
                1 3
                1 4
                2 3
                2 4
                2 5
                2 6
                5 7
                6 7
                """;

        String expected = """
                4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC212D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
