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
public class ABC251D {

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

    // https://atcoder.jp/contests/abc251/submissions/58531224

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int w = sc.nextInt();
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (i <= w) {
                ans.add(i);
            }
            if (i * 100 <= w) {
                ans.add(i * 100);
            }
            if (i * 10000 <= w) {
                ans.add(i * 10000);
            }
        }
        System.out.println(ans.size());
        for (var a : ans) {
            System.out.print(a + " ");
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                   6
                """;

        String expected = """
                                          3
                1 2 3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC251D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                   12
                """;

        String expected = """
                                          6
                2 5 1 2 5 1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC251D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC251D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC251D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
