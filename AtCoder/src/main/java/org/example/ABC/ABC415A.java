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
public class ABC415A {

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
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        int x = sc.nextInt();
        String s = "Yes";
        if (!set.contains(x)) {
            s = "No";
        }

        System.out.println(s);
    }
//}

    @Test
    public void Case1() {

        String input = """
                5
                3 1 4 1 5
                4
                
                """;

        String expected = """
                Yes
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415A.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                4
                100 100 100 100
                100
                
                """;

        String expected = """
                Yes
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415A.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                6
                2 3 5 7 11 13
                1
                
                """;

        String expected = """
                No
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415A.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415A.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
