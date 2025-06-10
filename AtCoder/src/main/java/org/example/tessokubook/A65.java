package org.example.tessokubook;

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
public class A65 {

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
        int[] aa = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            aa[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        for (int i = n; i > 1; i--) {
            dp[aa[i]] += dp[i] + 1;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(dp[i] + " ");
        }

    }
//}

    @Test
    public void Case1() {

        String input = """
                7
                1 1 3 2 4 4
                
                """;

        String expected = """
                6 1 3 2 0 0 0
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A65.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                15
                1 2 1 1 1 6 2 6 9 10 6 12 13 12
                
                """;

        String expected = """
                14 2 0 0 0 8 0 0 2 1 0 3 1 0 0
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A65.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A65.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A65.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
