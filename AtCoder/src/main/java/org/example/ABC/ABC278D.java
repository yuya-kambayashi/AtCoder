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
public class ABC278D {

    final private StandardInputSnatcher in = new StandardInputSnatcher();
    final private StandardOutputSnatcher out = new StandardOutputSnatcher();

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
//import java.util.stream.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        long[] aa = new long[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        long offset = 0;
        Map<Integer, Long> map = new HashMap<>();
        boolean isFilled = false;
        long filledValue = 0;
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            switch (t) {
                case 1: {
                    int x = sc.nextInt();
                    filledValue = x;
                    isFilled = true;
                    offset = 0;
                    map.clear();
                    break;
                }
                case 2: {
                    int ti = sc.nextInt();
                    ti--;
                    int x = sc.nextInt();
                    map.put(ti, map.getOrDefault(ti, 0l) + x);
                    break;
                }
                case 3: {
                    int ti = sc.nextInt();
                    ti--;
                    long a = isFilled ? filledValue : aa[ti];
                    System.out.println(a + offset + map.getOrDefault(ti, 0l));

                    break;
                }
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       5
                3 1 4 1 5
                6
                3 2
                2 3 4
                3 3
                1 1
                2 3 4
                3 3
                """;

        String expected = """
                                          1
                8
                5
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC278D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       1
                1000000000
                8
                2 1 1000000000
                2 1 1000000000
                2 1 1000000000
                2 1 1000000000
                2 1 1000000000
                2 1 1000000000
                2 1 1000000000
                3 1
                """;

        String expected = """
                8000000000
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC278D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       10
                1 8 4 15 7 5 7 5 8 0
                20
                2 7 0
                3 7
                3 8
                1 7
                3 3
                2 4 4
                2 4 9
                2 10 5
                1 10
                2 4 2
                1 10
                2 3 1
                2 8 11
                2 3 14
                2 1 9
                3 8
                3 8
                3 1
                2 6 5
                3 7
                """;

        String expected = """
                                          7
                5
                7
                21
                21
                19
                10
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC278D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC278D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
