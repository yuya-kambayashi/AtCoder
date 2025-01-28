package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC230D {

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

    // https://atcoder.jp/contests/abc230/submissions/51173811

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int d = sc.nextInt();
        List<Pair> pp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pp.add(new Pair(sc.nextInt(), sc.nextInt()));
        }
        pp.sort(Comparator.comparingInt(Pair::getTo).thenComparingInt(Pair::getFrom));
//        Collections.sort(pp, new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                int diff_to = o1.to - o2.to;
//                if (diff_to != 0) {
//                    return diff_to;
//                }
//                return o1.from - o2.from;
//            }
//        });

        int ans = 1;
        int start = pp.get(0).to;
        int end = start + d - 1;
        for (int i = 1; i < n; i++) {
            if (pp.get(i).from <= end) {
                continue;
            } else {
                start = pp.get(i).to;
                end = start + d - 1;
                ans++;
            }
        }


        System.out.println(ans);
    }

    static class Pair {
        int from, to;

        public Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       3 3
                1 2
                4 7
                5 9
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC230D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       3 3
                1 2
                4 7
                4 9
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC230D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       5 2
                1 100
                1 1000000000
                101 1000
                9982 44353
                1000000000 1000000000
                """;

        String expected = """
                3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC230D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC230D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
