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
public class ABC415E {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();

        System.out.println(n);
    }
//}

    @Test
    public void Case1() {

        String input = """
                2 2
                3 2
                4 1
                1 3 6
                
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                2 2
                3 2
                4 1
                1 3 6
                
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                4 7
                35 29 36 88 58 15 25
                99 7 49 61 67 4 57
                96 92 3 49 49 36 90
                72 89 40 44 24 53 45
                55 43 23 71 77 6 94 19 27 21
                
                """;

        String expected = """
                20
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
