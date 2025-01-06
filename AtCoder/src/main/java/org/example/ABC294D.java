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

        int n = sc.nextInt();
        int q = sc.nextInt();

        Queue<Integer> que = new LinkedList<>();
        Set<Integer> called = new HashSet<>();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            que.offer(i + 1);
        }

        for (int i = 0; i < q; i++) {
            int e = sc.nextInt();
            if (e == 1) {
                if (!que.isEmpty()) {
                    int guest = que.poll();
                    called.add(guest);
                }

            } else if (e == 2) {
                int x = sc.nextInt();
                times[x - 1]++;

            } else if (e == 3) {

                for (var guest : called) {
                    if (times[guest - 1] == 0) {
                        System.out.println(guest);
                        break;
                    }
                }

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
