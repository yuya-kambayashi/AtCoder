package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC216D {

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

    //https://atcoder.jp/contests/abc216/submissions/25459428
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        ArrayList<Integer>[] aaa = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            aaa[i] = new ArrayList<>();
        }
        int[] deg = new int[n];
        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            int p = sc.nextInt();
            p--;
            for (int j = 1; j < k; j++) {
                int q = sc.nextInt();
                q--;
                aaa[p].add(q);
                deg[q]++;
                p = q;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                que.add(i);
            }
        }
        int k = 0;
        while (!que.isEmpty()) {
            int x = que.poll();
            k++;
            for (int y : aaa[x]) {
                deg[y]--;
                if (deg[y] == 0) {
                    que.add(y);
                }
            }
        }
        System.out.println(k == n ? "Yes" : "No");

    }
//}

    @Test
    public void Case1() {

        String input = """
                                       2 2
                2
                1 2
                2
                1 2
                """;

        String expected = """
                Yes
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC216D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       2 2
                2
                1 2
                2
                2 1
                """;

        String expected = """
                No
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC216D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC216D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC216D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
