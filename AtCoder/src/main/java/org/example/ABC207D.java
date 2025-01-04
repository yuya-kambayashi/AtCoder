package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC207D {

    private StandardInputSnatcher in = new StandardInputSnatcher();
    private StandardOutputSnatcher out = new StandardOutputSnatcher();

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

    // https://atcoder.jp/contests/abc207/submissions/24928747
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        List<Point> S = new ArrayList<>();
        List<Point> T = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            S.add(new Point(sc.nextInt(), sc.nextInt()));
        }
        for (int i = 0; i < n; i++) {
            T.add(new Point(sc.nextInt(), sc.nextInt()));
        }
        double centerSx = 0;
        double centerSy = 0;
        double centerTx = 0;
        double centerTy = 0;
        for (int i = 0; i < n; i++) {
            centerSx += S.get(i).x;
            centerSy += S.get(i).y;
            centerTx += T.get(i).x;
            centerTy += T.get(i).y;
        }
        centerSx /= n;
        centerSy /= n;
        centerTx /= n;
        centerTy /= n;
        for (int i = 0; i < n; i++) {
            S.get(i).x -= centerSx;
            S.get(i).y -= centerSy;
            T.get(i).x -= centerTx;
            T.get(i).y -= centerTy;
        }

        double theta_s0 = 0;
        for (int i = 0; i < n; i++) {
            Point s0 = S.get(i);
            if (s0.x != 0 || s0.y != 0) {
                theta_s0 = Math.atan2(s0.y, s0.x);
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            Point t = T.get(i);
            double theta_t = Math.atan2(t.y, t.x);
            double theta = theta_t - theta_s0;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                Point s = S.get(j);
                double s_x_ = Math.cos(theta) * s.x - Math.sin(theta) * s.y;
                double s_y_ = Math.sin(theta) * s.x + Math.cos(theta) * s.y;
                boolean flag2 = false;
                for (int k = 0; k < n; k++) {
                    Point tk = T.get(k);
                    if (Math.abs(s_x_ - tk.x) <= 0.000006 && Math.abs(s_y_ - tk.y) <= 0.000006) {
                        flag2 = true;
                        break;
                    }
                }
                flag &= flag2;

            }
            if (flag) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }

    static class Point {

        double x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //}
    @Test
    public void Case1() {

        String input = """
                                       3
                0 0
                0 1
                1 0
                2 0
                3 0
                3 1
                """;

        String expected = """
                Yes
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC207D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       3
                1 0
                1 1
                3 0
                -1 0
                -1 1
                -3 0
                """;

        String expected = """
                No
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC207D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                                       4
                0 0
                2 9
                10 -2
                -6 -7
                0 0
                2 9
                10 -2
                -6 -7
                """;

        String expected = """
                Yes
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC207D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                                       6
                10 5
                -9 3
                1 -5
                -6 -5
                6 9
                -9 0
                -7 -10
                -10 -5
                5 4
                9 0
                0 -10
                -10 -2
                """;

        String expected = """
                Yes
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC207D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
