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
public class A34 {

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

    // https://atcoder.jp/contests/tessoku-book/submissions/51540195

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int x = sc.nextInt();
        final int y = sc.nextInt();
        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }
        int[] grundy = new int[100001];
        for (int i = 0; i < 100001; i++) {
            boolean[] transmit = {false, false, false};
            if (i >= x) {
                transmit[grundy[i - x]] = true;
            }
            if (i >= y) {
                transmit[grundy[i - y]] = true;
            }

            if (!transmit[0]) {
                grundy[i] = 0;
            } else if (!transmit[1]) {
                grundy[i] = 1;
            } else {
                grundy[i] = 2;
            }
        }
        int xorSum = 0;
        for (int i = 0; i < n; i++) {
            xorSum ^= grundy[aa[i]];
        }
        if (xorSum == 0) {
            System.out.println("Second");
        } else {
            System.out.println("First");
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                2 2 3
                5 8
                
                """;

        String expected = """
                First
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A34.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                2 2 3
                7 8
                
                """;

        String expected = """
                Second
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A34.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A34.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A34.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
