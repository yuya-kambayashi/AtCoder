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
public class ABC223D {

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


    // https://atcoder.jp/contests/abc223/submissions/48362440

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        Node[] nn = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nn[i] = new Node();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            nn[a].list.add(b);
            nn[b].inThis++;
        }
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (nn[i].inThis == 0) {
                que.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (!que.isEmpty()) {
            int a = que.poll();
            count++;
            sb.append(a + " ");
            for (int s : nn[a].list) {
                nn[s].inThis--;
                if (nn[s].inThis == 0) {
                    que.add(s);
                }
            }
        }
        if (count != n) {
            System.out.print(-1);
        } else {
            System.out.print(sb);
        }
    }

    public static class Node {
        int inThis;
        ArrayList<Integer> list;

        public Node() {
            inThis = 0;
            list = new ArrayList<>();
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       4 3
                2 1
                3 4
                2 4
                """;

        String expected = """
                2 1 3 4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC223D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       2 3
                1 2
                1 2
                2 1
                """;

        String expected = """
                -1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC223D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC223D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC223D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
