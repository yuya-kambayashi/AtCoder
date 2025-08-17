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
public class ABC419C {

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

        int N = sc.nextInt();
        int[] R = new int[N];
        int[] C = new int[N];

        for (int i = 0; i < N; i++) {
            R[i] = sc.nextInt();
            C[i] = sc.nextInt();
        }

        int minR = Arrays.stream(R).min().getAsInt();
        int maxR = Arrays.stream(R).max().getAsInt();
        int minC = Arrays.stream(C).min().getAsInt();
        int maxC = Arrays.stream(C).max().getAsInt();

        int ans = Math.max((maxR - minR + 1) / 2, (maxC - minC + 1) / 2);
        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        String input = """
                3
                2 3
                5 1
                8 1
                
                """;

        String expected = """
                3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC419C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                5
                6 7
                6 7
                6 7
                6 7
                6 7
                
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC419C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                6
                91 999999986
                53 999999997
                32 999999932
                14 999999909
                49 999999985
                28 999999926
                
                """;

        String expected = """
                44
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC419C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC419C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
