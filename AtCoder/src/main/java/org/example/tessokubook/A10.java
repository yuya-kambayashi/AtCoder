package org.example.tessokubook;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;

import org.example.template.StandardInputSnatcher;
import org.example.template.StandardOutputSnatcher;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Test;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class A10 {

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
        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }

        int[] fromLeft = new int[n];
        int[] fromRight = new int[n];

        fromLeft[0] = aa[0];
        for (int i = 1; i < n; i++) {
            fromLeft[i] = Math.max(fromLeft[i - 1], aa[i]);
        }
        fromRight[n - 1] = aa[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            fromRight[i] = Math.max(fromRight[i + 1], aa[i]);
        }

        int d = sc.nextInt();

        for (int i = 0; i < d; i++) {
            int left = sc.nextInt() - 1;
            int right = sc.nextInt() - 1;
            int t = Math.max(fromLeft[left - 1], fromRight[right + 1]);
            System.out.println(t);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                7
                1 2 5 5 2 3 1
                2
                3 5
                4 6
                
                """;

        String expected = """
                3
                5
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A10.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A10.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A10.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A10.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
