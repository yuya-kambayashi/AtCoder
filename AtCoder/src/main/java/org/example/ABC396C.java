package org.example;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC396C {

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

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        List<Integer> bb = new ArrayList<>();
        List<Integer> ww = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (t > 0) {
                bb.add(t);
            }
        }
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            if (t > 0) {
                ww.add(t);
            }
        }
        if (bb.isEmpty()) {
            System.out.println(0);
            return;
        }
        Collections.sort(bb);
        Collections.reverse(bb);
        Collections.sort(ww);
        Collections.reverse(ww);

        List<Integer> bb2 = new ArrayList<>();
        List<Integer> ww2 = new ArrayList<>();
        int t = 0;
        for (var b : bb) {
            bb2.add(b + t);
            t += b;
        }
        t = 0;
        for (var w : ww) {
            ww2.add(w + t);
            t += w;
        }
        long max = 0;
        for (int i = 0; i < ww2.size(); i++) {
            for (int j = i; j < bb2.size(); j++) {
                max = Math.max(max, ww2.get(i) + bb2.get(j));
            }
        }
        System.out.println(max);

    }

//}

    @Test
    public void Case1() {

        String input = """
                4 3
                8 5 -1 3
                3 -2 -4
                
                """;

        String expected = """
                19
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC396C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                4 3
                5 -10 -2 -5
                8 1 4
                
                """;

        String expected = """
                15
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC396C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                3 5
                -36 -33 -31
                12 12 28 24 27
                
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC396C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC396C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
