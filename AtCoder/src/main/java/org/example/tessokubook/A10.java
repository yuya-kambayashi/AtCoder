package org.example.tessokubook;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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
        int[] aa = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            aa[i] = sc.nextInt();
        }
        int d = sc.nextInt();
        int[] ll = new int[d + 1];
        int[] rr = new int[d + 1];
        for (int i = 1; i <= d; i++) {
            ll[i] = sc.nextInt();
            rr[i] = sc.nextInt();
        }

        int[] pp = new int[n + 1];
        pp[1] = aa[1];
        for (int i = 2; i <= n; i++) {
            pp[i] = Math.max(pp[i - 1], aa[i]);
        }

        int[] qq = new int[n + 1];
        qq[n] = aa[n];
        for (int i = n - 1; i >= 1; i--) {
            qq[i] = Math.max(qq[i + 1], aa[i]);
        }
        for (int i = 1; i <= d; i++) {
            int left = ll[i];
            int right = rr[i];
            System.out.println(Math.max(pp[left - 1], qq[right + 1]));
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
