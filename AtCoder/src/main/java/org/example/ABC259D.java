package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC259D {

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

    // https://atcoder.jp/contests/abc259/submissions/43235618

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int gx = sc.nextInt();
        int gy = sc.nextInt();
        long[] xx = new long[n];
        long[] yy = new long[n];
        long[] rr = new long[n];
        for (int i = 0; i < n; i++) {
            xx[i] = sc.nextLong();
            yy[i] = sc.nextLong();
            rr[i] = sc.nextLong();
        }
        int startCircle = -1, goalCircle = -1;
        for (int i = 0; i < n; i++) {
            long distS = (long) Math.pow(sx - xx[i], 2) + (long) Math.pow(sy - yy[i], 2);
            long distG = (long) Math.pow(gx - xx[i], 2) + (long) Math.pow(gy - yy[i], 2);
            if (distS == rr[i] * rr[i]) {
                startCircle = i;
            }
            if (distG == rr[i] * rr[i]) {
                goalCircle = i;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[startCircle] = true;
        que.add(startCircle);
        while (!que.isEmpty()) {
            var now = que.poll();

            for (int i = 0; i < n; i++) {
                if (i == now) {
                    continue;
                }
                if (visited[i]) {
                    continue;
                }

                long dx = xx[now] - xx[i];
                long dy = yy[now] - yy[i];
                long drp = rr[now] + rr[i];
                long drm = Math.abs(rr[now] - rr[i]);
                long dist = dx * dx + dy * dy;
                if (drm * drm <= dist && dist <= drp * drp) {
                    que.add(i);
                    visited[i] = true;
                }
            }
        }

        System.out.println(visited[goalCircle] ? "Yes" : "No");
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       4
                0 -2 3 3
                0 0 2
                2 0 2
                2 3 1
                -3 3 3
                """;

        String expected = """
                Yes
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC259D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       3
                0 1 0 3
                0 0 1
                0 0 2
                0 0 3
                """;

        String expected = """
                No
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC259D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC259D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC259D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
