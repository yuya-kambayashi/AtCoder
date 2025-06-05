package org.example.tessokubook;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.set;

import org.example.template.StandardInputSnatcher;
import org.example.template.StandardOutputSnatcher;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class A58 {

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

    // https://atcoder.jp/contests/tessoku-book/submissions/56629236

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int q = sc.nextInt();

        final var size = Integer.highestOneBit(n) << 1;
        final var segTree = new int[size * 2];

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();

            if (t == 1) {

                int pos = sc.nextInt();
                int value = sc.nextInt();

                int index = pos + size - 1;
                segTree[index] = value;
                index /= 2;
                while (index > 0) {
                    segTree[index] = Math.max(segTree[index * 2], segTree[index * 2 + 1]);
                    index /= 2;
                }
            } else if (t == 2) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(query(segTree, l, r, 1, size + 1, 1));
            }
        }
    }

    static int query(int[] segTree, int l, int r, int a, int b, int u) {
        if (r <= a || b <= l) {
            return Integer.MIN_VALUE;
        }
        if (l <= a && b <= r) {
            return segTree[u];
        }
        int mid = (a + b) / 2;
        int left = query(segTree, l, r, a, mid, u * 2);
        int right = query(segTree, l, r, mid, b, u * 2 + 1);
        return Math.max(left, right);
    }
//}

    @Test
    public void Case1() {

        String input = """
                8 4
                1 3 16
                2 4 7
                1 5 13
                2 4 7
                
                """;

        String expected = """
                0
                13
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A58.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A58.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A58.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A58.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
