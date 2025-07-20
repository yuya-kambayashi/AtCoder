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

    // https://atcoder.jp/contests/abc415/submissions/67789647
    public static class Pair {
        long a, b;

        public Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int m = sc.nextInt();
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            pairs.add(new Pair(sc.nextLong(), sc.nextLong()));
        }
        Collections.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Long.compare(o1.a - o1.b, o2.a - o2.b);
            }
        });

        long empty = n;
        long count = 0;
        for (Pair pair : pairs) {
            if (empty < pair.a) {
                continue;
            }
            long d = pair.a - pair.b;
            long times = (empty - pair.a) / d + 1;
            count += times;
            empty -= times * d;
        }
        System.out.println(count);
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
