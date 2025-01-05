package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC224D {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();

        System.out.println();
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       5
                1 2
                1 3
                1 9
                2 9
                3 9
                3 9 2 4 5 6 7 8
                """;

        String expected = """
                5
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC224D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                                       5
                1 2
                1 3
                1 9
                2 9
                3 9
                1 2 3 4 5 6 7 8
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC224D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                                       12
                8 5
                9 6
                4 5
                4 1
                2 5
                8 9
                2 1
                3 6
                8 7
                6 5
                7 4
                2 3
                1 2 3 4 5 6 8 7
                """;

        String expected = """
                -1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC224D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                                       12
                6 5
                5 4
                4 1
                4 7
                8 5
                2 1
                2 5
                6 9
                3 6
                9 8
                8 7
                3 2
                2 3 4 6 1 9 7 8
                """;

        String expected = """
                16
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC224D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
