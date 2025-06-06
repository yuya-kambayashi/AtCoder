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
public class A32 {

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

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        boolean[] dp = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i >= a && !dp[i - a]) {
                dp[i] = true;
            } else if (i >= b && !dp[i - b]) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }
        String ret = "First";
        if (!dp[n]) {
            ret = "Second";
        }
        System.out.println(ret);


    }
//}

    @Test
    public void Case1() {

        String input = """
                8 2 3
                
                """;

        String expected = """
                First
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A32.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                6 2 3
                
                """;

        String expected = """
                Second
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A32.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                2 2 3
                """;

        String expected = """
                First
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A32.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A32.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
