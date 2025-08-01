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
public class ABC411C {

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

    // https://atcoder.jp/contests/abc411/submissions/66938372

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int q = sc.nextInt();

        boolean[] black = new boolean[n + 2];
        int seg = 0;

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();

            boolean leftBlack = black[a - 1];
            boolean rightBlack = black[a + 1];
            boolean currentBlack = black[a];

            if (!currentBlack) {
                black[a] = true;

                if (!leftBlack && !rightBlack) {
                    seg++;
                } else if (leftBlack && rightBlack) {
                    seg--;
                }
            } else {
                black[a] = false;
                if (!leftBlack && !rightBlack) {
                    seg--;
                } else if (leftBlack && rightBlack) {
                    seg++;
                }
            }
            System.out.println(seg);

        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                5 7
                2 3 3 5 1 5 2
                
                """;

        String expected = """
                1
                1
                1
                2
                2
                1
                1
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC411C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                1 2
                1 1
                
                """;

        String expected = """
                1
                0
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC411C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                3 3
                1 3 2
                
                """;

        String expected = """
                1
                2
                1
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC411C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC411C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
