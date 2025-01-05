package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC294D {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int q = sc.nextInt();
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            que.add(i);
        }
        Set<Integer> called = new TreeSet<>();
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                int p = que.poll();
                called.add(p);
            } else if (t == 2) {
                int x = sc.nextInt();
                called.remove(x);
            } else {
                int p = called.iterator().next();
                System.out.println(p);
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       4 10
                1
                1
                3
                2 1
                1
                2 3
                3
                1
                2 2
                3
                """;

        String expected = """
                                          1
                2
                4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC294D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC294D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                   IN3
                """;

        String expected = """
                OUT3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC294D.main(null);
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

        ABC294D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
