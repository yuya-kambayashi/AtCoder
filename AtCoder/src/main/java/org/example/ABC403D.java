package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC403D {

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
//import java.util.stream.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] a = new int[n];

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            count.put(a[i], count.getOrDefault(a[i], 0) + 1);
        }

        int removed = 0;

        if (d == 0) {
            // 特別ケース: D=0 のとき、同じ数が2個以上あるとダメ
            for (int c : count.values()) {
                removed += c - 1;
            }
        } else {
            List<Integer> keys = new ArrayList<>(count.keySet());
            Collections.sort(keys);

            for (int x : keys) {
                if (count.containsKey(x)) {
                    int cntX = count.get(x);
                    if (count.containsKey(x + d)) {
                        int cntXD = count.get(x + d);
                        int min = Math.min(cntX, cntXD);
                        // x+D側から min 個削除
                        count.put(x + d, cntXD - min);
                        removed += min;
                    }
                }
            }
        }

        System.out.println(removed);
    }
//}

    @Test
    public void Case1() {

        String input = """
                5 2
                3 1 4 1 5
                
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC403D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                4 3
                1 6 1 8
                
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC403D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                10 3
                1 6 2 10 2 3 2 10 6 4
                
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC403D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                6 2
                1 3 3 4 5 5
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC403D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
