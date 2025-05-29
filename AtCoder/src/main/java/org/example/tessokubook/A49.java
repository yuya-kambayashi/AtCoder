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
public class A49 {

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
        int[] pp = new int[n];
        int[] qq = new int[n];
        int[] rr = new int[n];
        for (int i = 0; i < n; i++) {
            pp[i] = sc.nextInt() - 1;
            qq[i] = sc.nextInt() - 1;
            rr[i] = sc.nextInt() - 1;
        }

        int[] tt = new int[20];

        for (int i = 0; i < n; i++) {
            int as = getScorePlus(tt, pp[i], qq[i], rr[i]);
            int bs = getScoreMinus(tt, pp[i], qq[i], rr[i]);

            if (as <= bs) {
                System.out.println("B");
                tt[pp[i]]--;
                tt[qq[i]]--;
                tt[rr[i]]--;
            } else {
                System.out.println("A");
                tt[pp[i]]++;
                tt[qq[i]]++;
                tt[rr[i]]++;
            }
        }
    }

    static int getScorePlus(int[] arr, int p, int q, int r) {
        int score = 0;
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            if (i == p || i == q || i == r) {
                a++;
            }
            if (a == 0) {
                score++;
            }
        }
        return score;
    }

    static int getScoreMinus(int[] arr, int p, int q, int r) {
        int score = 0;
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            if (i == p || i == q || i == r) {
                a--;
            }
            if (a == 0) {
                score++;
            }
        }
        return score;
    }
//}

    @Test
    public void Case1() {

        String input = """
                3
                1 2 3
                2 3 4
                3 4 5
                
                """;

        String expected = """
                A
                B
                A
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A49.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A49.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A49.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A49.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
