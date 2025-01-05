package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC272D {

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
                   3 1
                """;

        String expected = """
                                          0 1 2
                1 2 3
                2 3 4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC272D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                   10 5
                """;

        String expected = """
                                          0 3 2 3 2 3 4 5 4 5
                3 4 1 2 3 4 3 4 5 6
                2 1 4 3 2 3 4 5 4 5
                3 2 3 2 3 4 3 4 5 6
                2 3 2 3 4 3 4 5 4 5
                3 4 3 4 3 4 5 4 5 6
                4 3 4 3 4 5 4 5 6 5
                5 4 5 4 5 4 5 6 5 6
                4 5 4 5 4 5 6 5 6 7
                5 6 5 6 5 6 5 6 7 6
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC272D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC272D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC272D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
