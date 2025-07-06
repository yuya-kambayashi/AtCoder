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
public class ABC225D {

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

    // https://atcoder.jp/contests/abc225/submissions/53652192

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int q = sc.nextInt();

        int[] pre = new int[n + 1];
        int[] suf = new int[n + 1];

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                pre[y] = x;
                suf[x] = y;

            } else if (t == 2) {

                int x = sc.nextInt();
                int y = sc.nextInt();
                pre[y] = 0;
                suf[x] = 0;

            } else {
                int x = sc.nextInt();

                int k = x;
                while (k != 0) {
                    if (pre[k] == 0) {
                        break;
                    }
                    k = pre[k];
                }
                int top = k;
                int cnt = 0;
                StringBuilder sb = new StringBuilder();
                while (top != 0) {
                    sb.append(top + " ");
                    top = suf[top];
                    cnt++;
                }
                System.out.print(cnt + " ");
                System.out.println(sb);
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       7 14
                1 6 3
                1 4 1
                1 5 2
                1 2 7
                1 3 5
                3 2
                3 4
                3 6
                2 3 5
                2 4 1
                1 1 5
                3 2
                3 4
                3 6
                """;

        String expected = """
                                          5 6 3 5 2 7
                2 4 1
                5 6 3 5 2 7
                4 1 5 2 7
                1 4
                2 6 3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC225D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC225D.main(null);
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

        ABC225D.main(null);
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

        ABC225D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
