package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC273D {

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
                                       5 5 4 4
                3
                5 3
                2 2
                1 4
                4
                L 2
                U 3
                L 2
                R 4
                """;

        String expected = """
                                          4 2
                3 2
                3 1
                3 5
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC273D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                                       6 6 6 3
                7
                3 1
                4 3
                2 6
                3 4
                5 5
                1 1
                3 2
                10
                D 3
                U 3
                L 2
                D 2
                U 3
                D 3
                U 3
                R 3
                L 3
                D 1
                """;

        String expected = """
                                          6 3
                5 3
                5 1
                6 1
                4 1
                6 1
                4 1
                4 2
                4 1
                5 1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC273D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC273D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC273D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
