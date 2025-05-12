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
public class ABC240D {

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

    // https://atcoder.jp/contests/abc240/submissions/29590028

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        Deque<Ball> balls = new ArrayDeque<>();
        int size = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (balls.isEmpty() || balls.peek().num != a) {
                balls.push(new Ball(a, 1));
                size++;
            } else {
                Ball b = balls.pop();
                b.count++;
                if (b.count != a) {
                    balls.push(b);
                    size++;
                }
                if (b.count == a) {
                    size -= b.count - 1;
                }
            }
            System.out.println(size);
        }
    }

    static class Ball {
        int num, count;

        public Ball(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       5
                3 2 3 2 2
                """;

        String expected = """
                                          1
                2
                3
                4
                3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC240D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       10
                2 3 2 3 3 3 2 3 3 2
                """;

        String expected = """
                                          1
                2
                3
                4
                5
                3
                2
                3
                1
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC240D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC240D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC240D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
