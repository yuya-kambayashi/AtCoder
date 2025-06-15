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
public class ABC410B {

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
        final int q = sc.nextInt();
        int[] qq = new int[n + 1];
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            if (x != 0) {
                qq[x]++;
                System.out.print(x + " ");
            } else {
                int t = -1;
                int max = 999;
                for (int j = 1; j <= n; j++) {
                    if (qq[j] < max) {
                        t = j;
                        max = qq[j];
                    }
                }
                qq[t]++;
                System.out.print(t + " ");
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                4 5
                2 0 3 0 0
                
                """;

        String expected = """
                2 1 3 4 1
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC410B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                3 7
                1 1 0 0 0 0 0
                
                """;

        String expected = """
                1 1 2 3 2 3 1
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC410B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                6 20
                4 6 0 3 4 2 6 5 2 3 0 3 2 5 0 3 5 0 2 0
                
                """;

        String expected = """
                4 6 1 3 4 2 6 5 2 3 1 3 2 5 1 3 5 4 2 6
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC410B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC410B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
