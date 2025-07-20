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
public class ABC415D {

    private final StandardInputSnatcher in = new StandardInputSnatcher();
    private final StandardOutputSnatcher out = new StandardOutputSnatcher();

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
//public class Main {

    static class State {
        long bottle, empty;
        long seal;

        State(long bottle, long empty, long seal) {
            this.bottle = bottle;
            this.empty = empty;
            this.seal = seal;
        }

        @Override
        public int hashCode() {
            return Objects.hash(bottle, empty, seal);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof State)) return false;
            State o = (State) obj;
            return bottle == o.bottle && empty == o.empty && seal == o.seal;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int M = sc.nextInt();
        long[] A = new long[M];
        long[] B = new long[M];

        for (int i = 0; i < M; i++) {
            A[i] = sc.nextLong();
            B[i] = sc.nextLong();
        }
        Queue<State> queue = new ArrayDeque<>();
        Set<State> visited = new HashSet<>();

        long initBottle = N;
        queue.add(new State(initBottle, 0, 0));
        visited.add(new State(initBottle, 0, 0));

        long maxSeal = 0;

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            maxSeal = Math.max(maxSeal, cur.seal);

            // 飲む操作
            for (int i = 1; i <= cur.bottle; i++) {
                State next = new State(cur.bottle - i, cur.empty + i, cur.seal);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }

            // クーポンで交換
            for (int i = 0; i < A.length; i++) {
                var a = A[i];
                if (cur.empty >= a) {
                    State next = new State(cur.bottle + B[i], cur.empty - a, cur.seal + 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
        }

        System.out.println(maxSeal);
    }
//}

    @Test
    public void Case1() {

        String input = """
                5 3
                5 1
                4 3
                3 1
                
                """;

        String expected = """
                3
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                3 3
                5 1
                5 1
                4 2
                
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                415 8
                327 299
                413 396
                99 67
                108 51
                195 98
                262 180
                250 175
                234 187
                
                """;

        String expected = """
                11
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
