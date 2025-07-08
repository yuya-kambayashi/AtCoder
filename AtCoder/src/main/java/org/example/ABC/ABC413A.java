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
public class ABC413A {

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
        final int m = sc.nextInt();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sc.nextInt();
        }

        String ret = "No";
        if (sum <= m) {
            ret = "Yes";
        }

        System.out.println(ret);
    }
//}

    @Test
    public void Case1() {

        String input = """
                5 15
                3 1 4 1 5
                
                """;

        String expected = """
                Yes
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413A.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                5 5
                3 1 4 1 5
                
                """;

        String expected = """
                No
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413A.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                1 10000
                100
                
                """;

        String expected = """
                Yes
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413A.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413A.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
